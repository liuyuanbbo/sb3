package org.zmz.sb3.newfeatures.test.scopevalue;

import java.util.concurrent.Executors;
import java.util.concurrent.StructuredTaskScope;

// 1. 定义 ScopedValue（全局单例，不可变）
class ContextHolder {
    // 泛型指定存储类型，withInitial 定义默认值（无上下文时返回）
    public static final ScopedValue<String> USER_ID = ScopedValue.newInstance();

    public static final ScopedValue<String> REQUEST_ID = ScopedValue.newInstance();
}

// 2. 工具类：获取上下文（无侵入式）
class ContextUtils {
    // 直接通过 ScopedValue.get() 获取当前上下文值
    public static String getCurrentUserId() {
        return ContextHolder.USER_ID.get();
    }

    public static String getCurrentRequestId() {
        return ContextHolder.REQUEST_ID.get();
    }
}

// 3. 业务层：无需传递参数，直接获取上下文
class UserService {
    public void doBusiness() {
        // 业务逻辑中直接获取用户ID（无侵入）
        String userId = ContextUtils.getCurrentUserId();
        String requestId = ContextUtils.getCurrentRequestId();
        System.out.printf("[%s] 执行业务逻辑，操作用户：%s%n", requestId, userId);
    }
}

// 4. 入口：模拟 Web 拦截器（绑定上下文并执行业务）
public class TestScopeValueConcurrent1 {
    void main() {
        UserService userService = new UserService();

        // 模拟 3 个并发请求（使用虚拟线程池）
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            // 请求1：用户ID=1001，请求ID=req-2025-01
            executor.submit(() -> bindContextAndRun("1001", "req-2025-01", userService::doBusiness));

            // 请求2：用户ID=1002，请求ID=req-2025-02
            executor.submit(() -> bindContextAndRun("1002", "req-2025-02", userService::doBusiness));

            // 请求3：无用户ID（使用默认值），请求ID=req-2025-03
            executor.submit(() -> bindContextAndRun(null, "req-2025-03", userService::doBusiness));
        }

        // 测试父子线程传递（结构化并发）
        System.out.println("\n=== 父子线程传递测试 ===");
        ScopedValue.where(ContextHolder.USER_ID, "1003").where(ContextHolder.REQUEST_ID, "req-2025-04").run(() -> {
            // 父线程上下文
            userService.doBusiness();
            // 子线程（自动继承父线程上下文）
            try (var scope = StructuredTaskScope.open()) {
                scope.fork(() -> {
                    System.out.printf("[%s] 子线程执行，继承用户：%s%n", ContextUtils.getCurrentRequestId(),
                        ContextUtils.getCurrentUserId());
                    return null;
                });
                try {
                    scope.join();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    /**
     * 绑定上下文并执行任务
     * 
     * @param userId 用户ID（可为null，使用默认值）
     * @param requestId 请求ID
     * @param task 业务任务
     */
    private static void bindContextAndRun(String userId, String requestId, Runnable task) {
        // 链式绑定多个 ScopedValue，run() 内生效，执行后自动清理
        ScopedValue.where(ContextHolder.REQUEST_ID, requestId)
            .where(ContextHolder.USER_ID, userId != null ? userId : ContextHolder.USER_ID.get()).run(task); // 任务执行完毕，上下文自动销毁（无内存泄漏）
    }
}

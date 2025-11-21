package io.zjc;

import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SaTokenSimpleApp9921 {
    public static void main(String[] args) {
        SpringApplication.run(SaTokenSimpleApp9921.class, args);
        log.info("启动成功，Sa-Token 配置如下：{}", SaManager.getConfig());
    }
}

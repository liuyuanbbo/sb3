package org.zmz.sb3.newfeatures.test.cf;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CfDemo01 {

    public static final Logger LOG = LoggerFactory.getLogger(CfDemo01.class);

    @Test
    public void test1() {
        LOG.info(">>>> 开始时间 {} <<<<", LocalDateTime.now());
        for1();
        LOG.info(">>>> 结束时间 {} <<<<", LocalDateTime.now());
    }

    @Test
    public void test2() {
        LOG.info(">>>> 开始时间222 {} <<<<", LocalDateTime.now());
        List<CompletableFuture<Void>> futures = for2();
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        LOG.info(">>>> 结束时间222 {} <<<<", LocalDateTime.now());
    }

    public void for1() {
        for (int i = 0; i < 10; i++) {
            sleep();
        }
    }

    public List<CompletableFuture<Void>> for2() {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            CompletableFuture<Void> cf = CompletableFuture.runAsync(CfDemo01::sleep, executorService);
            futures.add(cf);
        }
        return futures;
    }

    public static void sleep() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            LOG.error(e.getMessage());
        }
    }
}

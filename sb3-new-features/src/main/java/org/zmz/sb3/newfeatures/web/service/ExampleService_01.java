package org.zmz.sb3.newfeatures.web.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ExampleService_01 {

    @Autowired
    ThreadPoolExecutor threadPoolExecutor;

    public List<String> mapping01Service(List<String> list) {
        List<String> res = new ArrayList<>();
        for (String s : list) {
            this.slp();
            res.add(s + "<-->");
        }
        return res;
    }

    public List<String> mapping02Service(List<String> list) {
        List<String> res = new ArrayList<>();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (String s : list) {
            CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> this.slp2(res, s), threadPoolExecutor);
            futures.add(cf);
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return res;
    }

    public void slp() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void slp2(List<String> res, String s) {
        try {
            TimeUnit.SECONDS.sleep(1);
            log.info(">>> {} >>> ", s);
            res.add(s + "<-->");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

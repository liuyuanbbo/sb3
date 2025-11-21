package io.jcz.antlr4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class Antlr4Example01 {

    static final Logger LOG = LoggerFactory.getLogger(Antlr4Example01.class);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Antlr4Example01 example = new Antlr4Example01();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.add("h");
        list.add("i");
        list.add("j");


        List<String> res = new ArrayList<>();
        long start = System.currentTimeMillis();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (String s : list) {
            CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> example.m2(res, s));
            futures.add(cf);
            //res.add(s + "<-->");
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        long end = System.currentTimeMillis();
        LOG.info("耗时: {}", end - start);
        LOG.info("{}",res);
    }

    public void m1() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void m2(List<String> res, String s) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String ss = s + "<-->";
        LOG.info("{}", ss);
        res.add(ss);
    }
}

package org.zmz.sb3.newfeatures.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zmz.sb3.newfeatures.web.service.ExampleService_01;

import java.util.List;

@RestController
@RequestMapping("/example01")
@Slf4j
public class ExampleController_01 {

    @Autowired
    ExampleService_01 exampleService01;

    private static final List<String> LIST =
            List.of(
                    "a", "b", "c", "d", "e", "f", "g",
                    "h", "i", "j", "k", "l", "m", "n"
            );

    @GetMapping("/mapping01")
    public List<String> mapping01() {
        long start = System.currentTimeMillis();
        List<String> rs = exampleService01.mapping01Service(LIST);
        long end = System.currentTimeMillis();
        log.info("mapping01 耗时: {}", end - start);
        return rs;
    }

    @GetMapping("/mapping02")
    public List<String> mapping02() {
        long start = System.currentTimeMillis();
        List<String> rs = exampleService01.mapping02Service(LIST);
        long end = System.currentTimeMillis();
        log.info("mapping02 耗时: {}", end - start);
        return rs;
    }

}

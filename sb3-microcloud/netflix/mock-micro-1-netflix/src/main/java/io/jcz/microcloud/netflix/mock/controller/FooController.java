package io.jcz.microcloud.netflix.mock.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/foo")
public class FooController {

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUser(@PathVariable("id") Long id) {
        Map<String, Object> user = Map.of("id", id,
                "name", "张三",
                "email", "zhangsan@qq.com", "from",
                "mock-micro-1-netflix (port: 10001)");

        return ResponseEntity.ok(user);
    }

}

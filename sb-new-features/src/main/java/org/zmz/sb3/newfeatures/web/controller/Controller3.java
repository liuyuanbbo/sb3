package org.zmz.sb3.newfeatures.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/c3")
public class Controller3 {

    @PostMapping("/t1")
    public void t1(@RequestBody Map<String, Object> params) {
        List<Long> ids = (List<Long>) params.get("ids");
        System.out.println(ids);
    }

}

package com.zzyy.testsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouy262
 * @date 2021/5/8 16:55
 **/
@RestController
public class TestController {

    @GetMapping("/echo/{detail}")
    public String testHello(@PathVariable String detail) {


        System.out.println("hello:" + detail);
        return detail;
    }

}

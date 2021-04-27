package com.sl.user.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Hans
 * @Date 17:28 2020/8/1
 **/
@RestController
@RequestMapping("recource")
public class ResourceController {


    @SentinelResource(value = "hello")
    @GetMapping("hello")
    public String getResource() {
        return "success";
    }
}

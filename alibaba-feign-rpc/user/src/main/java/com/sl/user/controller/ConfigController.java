package com.sl.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Hans
 * @Date 10:08 2020/7/29
 **/
@RefreshScope
@RestController
@RequestMapping("v1/config")
public class ConfigController {
    @Value("${config.info:default}")
    String configInfo;

    @GetMapping
    public String getConfigInfo() {
        return configInfo;
    }

}

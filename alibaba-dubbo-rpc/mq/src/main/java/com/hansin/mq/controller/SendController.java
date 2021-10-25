package com.hansin.mq.controller;

import com.hansin.mq.service.Producer;
import com.hansin.opticalvallay.model.ApiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Date 10:28 2021/10/22
 **/
@RestController
@RequestMapping("v1/send")
public class SendController {
    @Autowired
    @Qualifier("syncProducer")
    private Producer producer;

    @GetMapping("simple")
    public ApiResult sendMsg() throws Exception {
        return new ApiResult().setData(producer.syncSend());
    }

}

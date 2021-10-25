package com.hansin.mq.service.impl;

import org.springframework.stereotype.Service;

/**
 * @Date 11:30 2021/10/22
 **/
@Service
public class OnewayConsumer extends AbstractConsumer{

    /**
     * 接收单向消息，根据topic及tag匹配
     * @throws Exception
     */
    @Override
    public void onewayReceive() throws Exception {

    }
}

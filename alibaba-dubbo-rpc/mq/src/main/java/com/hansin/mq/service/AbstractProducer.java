package com.hansin.mq.service;

import org.apache.rocketmq.client.producer.SendResult;

/**
 * @Date 9:52 2021/10/22
 **/
public class AbstractProducer implements Producer{
    @Override
    public SendResult syncSend() throws Exception {
        return null;
    }

    @Override
    public void asyncSend() throws Exception {

    }

    @Override
    public void onewaySend() throws Exception {

    }

    @Override
    public void scheduledSend() throws Exception {

    }

    @Override
    public void batchSend() throws Exception {

    }
}

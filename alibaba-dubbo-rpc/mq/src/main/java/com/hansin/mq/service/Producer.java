package com.hansin.mq.service;

import org.apache.rocketmq.client.producer.SendResult;

/**
 * @Date 9:48 2021/10/22
 **/
public interface Producer {

    /**
     * 同步消息
     * @return
     * @throws Exception
     */
    SendResult syncSend() throws Exception;

    /**
     * 异步消息
     * @throws Exception
     */
    void asyncSend() throws Exception;

    void onewaySend() throws Exception;

    void scheduledSend() throws Exception;

    void batchSend() throws Exception;
}

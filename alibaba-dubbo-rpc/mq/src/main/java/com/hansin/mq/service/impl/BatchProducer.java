package com.hansin.mq.service.impl;

import com.hansin.mq.service.AbstractProducer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Date 15:21 2021/11/1
 **/
@Service
public class BatchProducer extends AbstractProducer {
    @Value("${rocketmq.namesrv}")
    private String namesrv;

    @Override
    public void batchSend() throws Exception {
        DefaultMQProducer mqProducer = new DefaultMQProducer("batchGroup");
        mqProducer.setNamesrvAddr(namesrv);
        mqProducer.start();
        String topic = "BatchTest";
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(topic, "TagA", "OrderID001", "Hello world 0".getBytes()));
        messages.add(new Message(topic, "TagA", "OrderID002", "Hello world 1".getBytes()));
        messages.add(new Message(topic, "TagA", "OrderID003", "Hello world 2".getBytes()));
        try {
            mqProducer.send(messages);
        } catch (Exception e) {
            e.printStackTrace();
            //处理error
        }
    }
}

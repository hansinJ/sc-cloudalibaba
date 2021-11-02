package com.hansin.mq.service.impl;

import com.hansin.mq.consts.MqConst;
import com.hansin.mq.service.AbstractProducer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Date 14:58 2021/11/1
 **/
@Service
public class ScheduledProducer extends AbstractProducer {
    @Value("${rocketmq.namesrv}")
    private String namesrv;

    @Override
    public void scheduledSend() throws Exception {
        DefaultMQProducer mqProducer = new DefaultMQProducer("scheduleGroup");
        mqProducer.setNamesrvAddr(namesrv);
        mqProducer.start();
        int totalMessagesToSend = 100;
        for (int i = 0; i < totalMessagesToSend; i++) {
            Message message = new Message(MqConst.TEST_TOPIC_1, ("Hello scheduled message " + i).getBytes());
            // 设置延时等级3,这个消息将在10s之后发送(现在只支持固定的几个时间,详看delayTimeLevel)
            // 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
            message.setDelayTimeLevel(3);
            // 发送消息
            mqProducer.send(message);
        }
        // 关闭生产者
        mqProducer.shutdown();
    }
}

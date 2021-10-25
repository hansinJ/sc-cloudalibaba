package com.hansin.mq.service.impl;

import com.hansin.mq.consts.MqConst;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Date 11:29 2021/10/22
 **/
@Service
public class TopicConsumer extends AbstractConsumer {

    /**
     * 接收消息，根据topic及tag匹配
     *
     * @throws Exception
     */
    @Override
    public void topicReceive() throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(MqConst.SYN_GROUP);
        consumer.setNamesrvAddr("192.168.1.31:9876");
        // 订阅一个或者多个Topic，以及Tag来过滤需要消费的消息
        consumer.subscribe(MqConst.TEST_TOPIC_1, "*");
        // 注册回调实现类处理从brokder拉取回来的消息
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                System.out.printf("%s Receive New Messages: %s %n", Thread.currentThread().getName(), msgs);
                // 标记该消息已经被成功消费
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });
        consumer.start();
        System.out.printf("Consumer Started.%n");
    }
}

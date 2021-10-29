package com.hansin.mq.service.impl;

import com.hansin.mq.consts.MqConst;
import com.hansin.mq.service.AbstractProducer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Date 11:11 2021/10/22
 **/
@Service
public class OnewaySendProducer extends AbstractProducer {
    @Value("${rocketmq.namesrv}")
    private String namesrv;

    /**
     * 发送单向消息，没有任何返回结果
     *
     * @throws Exception
     */
    @Override
    public void onewaySend() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(MqConst.ONEWAY_GROUP);
        producer.setNamesrvAddr(namesrv);
        producer.start();
        for (int i = 0; i < 100; i++) {
            Message message = new Message(MqConst.ONEWAY_TOPIC,
                    MqConst.ONEWAY_TOPIC_TAG,
                    "hello".getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.sendOneway(message);
        }
        producer.shutdown();
    }
}

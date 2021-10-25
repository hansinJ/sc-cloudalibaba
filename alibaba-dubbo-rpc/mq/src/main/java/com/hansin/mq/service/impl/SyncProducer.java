package com.hansin.mq.service.impl;

import com.hansin.mq.consts.MqConst;
import com.hansin.mq.service.AbstractProducer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.stereotype.Service;

/**
 * @Date 9:51 2021/10/22
 **/
@Service
public class SyncProducer extends AbstractProducer {
    /**
     * 发送同步消息
     * @return
     * @throws MQClientException
     */
    @Override
    public SendResult syncSend() throws Exception {
        // 实例化消息生产者
        DefaultMQProducer producer = new DefaultMQProducer(MqConst.SYN_GROUP);
        // 设置nameSrv地址
        producer.setNamesrvAddr("192.168.1.31:9876");
        // 启动producer实例
        producer.start();

        for (int i = 0; i < 100; i++) {
            // 创建消息，并制定topic，tag和消息体
            Message message = new Message(MqConst.TEST_TOPIC_1,
                    MqConst.TEST_TOPIC_2_TAG_1,
                    ("hello " + i).getBytes(RemotingHelper.DEFAULT_CHARSET));
            // 发送消息到一个Broker
            SendResult sendResult = producer.send(message);
            // 通过sendResult返回消息是否成功送达
            System.out.printf("%s%n", sendResult);

        }
        // 如果不再发送消息，关闭Producer实例。
        producer.shutdown();
        return null;
    }


}

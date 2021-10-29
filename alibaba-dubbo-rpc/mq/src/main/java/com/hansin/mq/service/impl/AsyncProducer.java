package com.hansin.mq.service.impl;

import com.hansin.mq.consts.MqConst;
import com.hansin.mq.service.AbstractProducer;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Date 10:43 2021/10/22
 **/
@Service
public class AsyncProducer extends AbstractProducer {
    @Value("${rocketmq.namesrv}")
    private String namesrv;

    /**
     * 发送异步消息
     *
     * @throws Exception
     */
    @Override
    public void asyncSend() throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer(MqConst.ASYN_GROUP);
        producer.setNamesrvAddr(namesrv);
        producer.start();
        producer.setRetryTimesWhenSendAsyncFailed(0);

        int messageCount = 0;
        CountDownLatch countDownLatch = new CountDownLatch(messageCount);
        for (int i = 0; i < 100; i++) {
            final int index= 1;
            Message message = new Message(MqConst.TEST_TOPIC_2,
                    MqConst.TEST_TOPIC_2_TAG_1,
                    "message",
                    "hellow".getBytes(RemotingHelper.DEFAULT_CHARSET));
            // sendCallback 接收异步回调的结果
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    System.out.printf("%-10d OK %s %n", index,
                            sendResult.getMsgId());
                }

                @Override
                public void onException(Throwable e) {
                    System.out.printf("%-10d Exception %s %n", index, e);
                    e.printStackTrace();
                }
            });
        }
        // 等待5s
        countDownLatch.await(5, TimeUnit.SECONDS);
        producer.shutdown();
    }
}

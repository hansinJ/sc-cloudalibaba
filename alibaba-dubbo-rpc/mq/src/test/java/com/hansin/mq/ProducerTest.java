package com.hansin.mq;

import com.BaseTest;
import com.hansin.mq.service.Consumer;
import com.hansin.mq.service.Producer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * @Date 10:36 2021/10/22
 **/
public class ProducerTest extends BaseTest {
    @Autowired
    @Qualifier("syncProducer")
    private Producer producer;
    @Autowired
    @Qualifier("topicConsumer")
    private Consumer consumer;

    @Test
    public void simpleSend() throws Exception {
        producer.syncSend();
    }


    @Before
    public void setUp() throws Exception {
        topicConsumerTest();
    }

    public void topicConsumerTest() throws Exception{
        consumer.topicReceive();
//        Thread.sleep(50000);
    }
}

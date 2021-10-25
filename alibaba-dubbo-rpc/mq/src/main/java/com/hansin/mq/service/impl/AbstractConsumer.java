package com.hansin.mq.service.impl;

import com.hansin.mq.service.Consumer;

public abstract class AbstractConsumer implements Consumer {

    @Override
    public void topicReceive() throws Exception {

    }

    @Override
    public void onewayReceive() throws Exception {

    }
}

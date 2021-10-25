package com.hansin.mq.service;

public interface Consumer {
    void topicReceive() throws Exception;

    void onewayReceive() throws Exception;
}

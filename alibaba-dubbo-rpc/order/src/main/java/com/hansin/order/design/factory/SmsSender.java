package com.hansin.order.design.factory;

/**
 * @Date 17:15 2021/10/13
 **/
public class SmsSender implements Sender {
    @Override
    public void send() {
        System.out.println("smsSender");
    }
}

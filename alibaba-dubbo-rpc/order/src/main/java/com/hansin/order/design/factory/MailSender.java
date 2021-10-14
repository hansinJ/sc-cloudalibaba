package com.hansin.order.design.factory;

/**
 * @Date 17:14 2021/10/13
 **/
public class MailSender implements Sender {
    @Override
    public void send() {
        System.out.println("mailsender");
    }
}

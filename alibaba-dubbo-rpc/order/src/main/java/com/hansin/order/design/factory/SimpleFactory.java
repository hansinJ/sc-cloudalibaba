package com.hansin.order.design.factory;

/**
 * @Date 17:15 2021/10/13
 **/
public class SimpleFactory {

    public void produce(String type) {
        if (type.equals("mail")) {
            new MailSender().send();
        } else if (type.equals("sms")) {
            new SmsSender().send();
        } else {
            System.out.println("type not define");
        }

    }
}

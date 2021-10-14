package com.hansin.order.design.factory;

/**
 * @Date 9:53 2021/10/14
 **/
public class SendFactory {

    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }
}

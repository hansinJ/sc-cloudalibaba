package com.hansin.order.design.factory.abstractfactory;

import com.hansin.order.design.factory.MailSender;
import com.hansin.order.design.factory.Sender;
import com.hansin.order.design.factory.SmsSender;

/**
 * @Date 10:04 2021/10/14
 **/
public class MailProvider implements Provider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}

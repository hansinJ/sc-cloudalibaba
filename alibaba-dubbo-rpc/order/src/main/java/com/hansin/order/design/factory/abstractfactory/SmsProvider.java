package com.hansin.order.design.factory.abstractfactory;

import com.hansin.order.design.factory.Sender;
import com.hansin.order.design.factory.SmsSender;

/**
 * @Date 10:05 2021/10/14
 **/
public class SmsProvider implements Provider {
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}

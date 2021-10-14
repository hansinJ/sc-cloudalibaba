package com.hansin.order.design.factory;

import com.hansin.order.BaseTest;
import com.hansin.order.design.factory.abstractfactory.MailProvider;
import com.hansin.order.design.factory.abstractfactory.Provider;
import org.junit.Test;

/**
 * @Date 10:08 2021/10/14
 **/
public class FactoryTest extends BaseTest {


    @Test
    public void abstractFactoryTest(){
        Provider provider = new MailProvider();
        Sender sender = provider.produce();
        sender.send();
    }
}

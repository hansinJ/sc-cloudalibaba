package com.hansin.order.design;

import com.hansin.order.BaseTest;
import com.hansin.order.design.proxy.Consumer;
import com.hansin.order.design.proxy.ProxyHandler;
import com.hansin.order.design.proxy.UserClient;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Date 14:35 2021/10/12
 **/
public class ProxyTest extends BaseTest {


    @Test
    public void proxyTest() {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        Consumer consumer = new UserClient();
        InvocationHandler invocationHandler = new ProxyHandler(consumer);
        Consumer consumer1 = (Consumer) Proxy.newProxyInstance(consumer.getClass().getClassLoader(), consumer.getClass().getInterfaces(), invocationHandler);
        consumer1.buy("123");
    }


}

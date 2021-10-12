package com.hansin.order.design.proxy;

/**
 * 静态代理
 * 代理类持有被代理对象
 */
public class BusinessClient implements Consumer {
    Consumer userClient = new UserClient();

    @Override
    public boolean buy(String id) {
        System.out.println("BusinessClient + start");
        userClient.buy(id);
        System.out.println("BusinessClient + end");
        return false;
    }
}

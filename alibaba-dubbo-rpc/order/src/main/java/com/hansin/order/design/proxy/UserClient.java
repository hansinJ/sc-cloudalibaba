package com.hansin.order.design.proxy;

/**
 * @Date 14:41 2021/10/11
 **/
public class UserClient implements Consumer {
    @Override
    public boolean buy(String id) {
        System.out.println("UserClient wanna buy " + id);
        return false;
    }
}

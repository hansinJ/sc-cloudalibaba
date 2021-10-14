package com.hansin.order.design.adapt.adaptinterface;

/**
 * 定义抽象类实现接口适配，子类可以只关注部分方法
 */
public abstract class AbstractSource implements Sourceable{

    @Override
    public void method1() {
        System.out.println("method 1");
    }

    @Override
    public void method2() {
        System.out.println("method 2");
    }
}

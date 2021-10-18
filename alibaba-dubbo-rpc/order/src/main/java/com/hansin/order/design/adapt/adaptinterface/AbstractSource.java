package com.hansin.order.design.adapt.adaptinterface;

/**
 * 定义抽象类实现接口适配，子类可以只关注部分方法
 *
 * 当不希望实现一个接口中所有的方法时，可以创建一个抽象类Wrapper，实现所有方法，
 * 我们写别的类的时候，继承抽象类即可。
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

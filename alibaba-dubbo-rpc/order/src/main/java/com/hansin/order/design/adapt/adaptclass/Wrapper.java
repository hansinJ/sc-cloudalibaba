package com.hansin.order.design.adapt.adaptclass;

import com.hansin.order.design.adapt.Source;

/**
 * 类的适配:
 * 将Source类的方法适配到Target
 */
public class Wrapper extends Source implements Target {

    @Override
    public void method1() {
        System.out.println("target method 1");
    }

    @Override
    public void method2() {
        System.out.println("target method 2");
    }
}

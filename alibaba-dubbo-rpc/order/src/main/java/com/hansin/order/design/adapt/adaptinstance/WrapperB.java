package com.hansin.order.design.adapt.adaptinstance;

import com.hansin.order.design.adapt.Source;
import com.hansin.order.design.adapt.adaptclass.Target;

/**
 * 对象的适配:
 * 区别于类的适配，适配器持有被适配对象
 */
public class WrapperB implements Target {

    Source source;

    public WrapperB(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
        System.out.println("wrapperB method 1");
    }

    @Override
    public void method2() {
        source.method2();
        System.out.println("wrapperB method 2");
    }
}

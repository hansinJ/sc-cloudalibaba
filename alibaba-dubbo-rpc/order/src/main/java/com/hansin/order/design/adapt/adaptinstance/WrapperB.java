package com.hansin.order.design.adapt.adaptinstance;

import com.hansin.order.design.adapt.Source;
import com.hansin.order.design.adapt.adaptclass.Target;

/**
 * 对象的适配:
 * 区别于类的适配，适配器持有被适配对象
 *
 * 当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类，持有原类的一个实例，
 * 在Wrapper类的方法中，调用实例的方法就行
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

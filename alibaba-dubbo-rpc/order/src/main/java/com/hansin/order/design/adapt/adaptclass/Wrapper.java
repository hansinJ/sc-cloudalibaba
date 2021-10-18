package com.hansin.order.design.adapt.adaptclass;

import com.hansin.order.design.adapt.Source;

/**
 * 类的适配:
 * 将Source类的方法适配到Target
 *
 * 当希望将一个类转换成满足另一个新接口的类时，可以使用类的适配器模式，
 * 创建一个新类，继承原有的类，实现新的接口即可。
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

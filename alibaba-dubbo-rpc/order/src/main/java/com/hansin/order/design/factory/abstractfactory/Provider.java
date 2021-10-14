package com.hansin.order.design.factory.abstractfactory;

import com.hansin.order.design.factory.Sender;

/**
 * 抽象工厂模式，易于扩展，有新的功能，直接添加新的工厂类
 */
public interface Provider {

    Sender produce();
}

package com.hansin.order.design.bridge;

/**
 * @Date 15:31 2021/10/18
 **/
public class SourceBridge extends SourceManager{
    @Override
    public void method() {
        getSource().method();
    }
}

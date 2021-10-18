package com.hansin.order.design.bridge;

/**
 * @Date 15:28 2021/10/18
 **/
public abstract class SourceManager {
    private Source source;

    public void method(){
        getSource().method();
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }
}

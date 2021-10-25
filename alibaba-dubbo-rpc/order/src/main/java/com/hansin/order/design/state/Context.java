package com.hansin.order.design.state;

/**
 * @Date 15:03 2021/10/25
 **/
public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void method(){
        if("online".equals(state.getValue())){
            state.method1();
        }
        if("offline".equals(state.getValue())){
            state.method2();
        }
    }
}

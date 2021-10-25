package com.hansin.order.state;

import com.hansin.order.BaseTest;
import com.hansin.order.design.state.Context;
import com.hansin.order.design.state.State;
import org.junit.Test;

/**
 * @Date 15:07 2021/10/25
 **/
public class StateTest extends BaseTest {

    @Test
    public void test(){
        State state = new State();
        Context context = new Context(state);

        state.setValue("online");
        context.method();

        state.setValue("offline");
        context.method();
    }
}

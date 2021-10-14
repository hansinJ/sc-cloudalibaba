package com.hansin.order.design.adapt;

import com.hansin.order.BaseTest;
import com.hansin.order.design.adapt.adaptclass.Target;
import com.hansin.order.design.adapt.adaptclass.Wrapper;
import com.hansin.order.design.adapt.adaptinstance.WrapperB;
import com.hansin.order.design.adapt.adaptinterface.Sourceable;
import com.hansin.order.design.adapt.adaptinterface.SubA;
import com.hansin.order.design.adapt.adaptinterface.SubB;
import org.junit.Test;

/**
 * @Date 14:52 2021/10/14
 **/
public class AdaptTest extends BaseTest {

    /**
     * 类的适配:
     * 将Source类的方法适配到Target
     */
    @Test
    public void adaptClassTest() {
        Target target = new Wrapper();
        target.method1();
        target.method2();
    }

    /**
     * 对象的适配:
     * 区别于类的适配，适配器持有被适配对象
     */
    @Test
    public void adaptInstanceTest(){
        Source source = new Source();
        Target target = new WrapperB(source);
        target.method1();
        target.method2();
    }


    /**
     * 定义抽象类实现接口适配，子类可以只关注部分方法
     */
    @Test
    public void adaptInterface(){
        Sourceable subA = new SubA();
        Sourceable subB = new SubB();

        subA.method1();
        subB.method2();
    }
}

package com.hansin.order.design.proxy;

import com.hansin.order.BaseTest;
import com.hansin.order.design.proxy.BusinessClient;
import org.junit.Test;

/**
 * @Date 14:53 2021/10/11
 **/
public class StaticProxyTest extends BaseTest {

    /**
     * 静态代理: 扩展性差
     */
    @Test
    public void staticTest() {
        BusinessClient businessClient = new BusinessClient();
        boolean success = businessClient.buy("123");
    }

}

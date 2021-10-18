package com.hansin.order.design.bridge;

import com.hansin.order.BaseTest;
import org.junit.Test;

/**
 * @Date 15:32 2021/10/18
 **/
public class BridgeTest extends BaseTest {

    @Test
    public void test(){
        SourceManager sourceBridge = new SourceBridge();
        Source sourceSub1 = new SourceSub1();
        sourceBridge.setSource(sourceSub1);
        sourceBridge.method();

        Source sourceSub2 = new SourceSub2();
        sourceBridge.setSource(sourceSub2);
        sourceBridge.method();
    }
}

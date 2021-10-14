package com.hansin.order.design.singleton;

/**
 * @Date 16:39 2021/10/13
 **/
public class Singleton {

    /**
     * 私有化构造函数
     */
    private Singleton() {

    }

    public static class SingletonFactory {
        private static Singleton singleton = new Singleton();
    }

    /**
     * 内部类只有在第一次调用的时候才会去实例化，
     * JVM会保证在实例化的时候会保证线程安全
     **/
    public static Singleton getInstance() {
        return SingletonFactory.singleton;
    }

    public Object readResolve(){
        return getInstance();
    }

}

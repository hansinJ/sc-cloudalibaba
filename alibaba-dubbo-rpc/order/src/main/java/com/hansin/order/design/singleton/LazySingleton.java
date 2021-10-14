package com.hansin.order.design.singleton;

/**
 * 单例模式: 懒加载线程安全
 * 双重校验锁单例模式
 **/
public class LazySingleton {
    // volatile 解决指令重排的顺序性
    public static volatile LazySingleton singleton = null;

    public static LazySingleton getInstance() {
        // 没有实例化才需要加锁
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                // 避免第一个线程释放锁后，第二个获得锁的线程重复创建对象
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }

}

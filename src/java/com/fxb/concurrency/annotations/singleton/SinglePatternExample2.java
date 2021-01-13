package com.fxb.concurrency.annotations.singleton;

import com.fxb.concurrency.annotations.NotThreadSafe;
import com.fxb.concurrency.annotations.ThreadSafe;

/**
 * 单例模式：饿汉模式
 * TODO：单例实例在类加载的时候进行创建
 */
@ThreadSafe
public class SinglePatternExample2 {
    //私有化，外部只能通过静态方法获取对象
    private SinglePatternExample2() {}
    //单例对象
    private static SinglePatternExample2 instance = new SinglePatternExample2();
    //静态的工厂方法，保证对象只能初始化一次
    public static SinglePatternExample2 getInstance() {
        return instance;
    }
}

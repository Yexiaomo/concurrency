package com.fxb.concurrency.example.singleton;

import com.fxb.concurrency.annotations.ThreadSafe;

/**
 * 单例模式：使用静态代码块的饿汉模式
 */
@ThreadSafe
public class SinglePatternExample2 {
    //私有化，外部只能通过静态方法获取对象
    private SinglePatternExample2() {}
    //单例对象
    private static SinglePatternExample2 instance = null;
    static {
        instance = new SinglePatternExample2();
    }
    //静态的工厂方法，保证对象只能初始化一次
    public static SinglePatternExample2 getInstance() {
        return instance;
    }
}

package com.fxb.concurrency.annotations.singleton;

import com.fxb.concurrency.annotations.NotRecommend;
import com.fxb.concurrency.annotations.NotThreadSafe;
import com.fxb.concurrency.annotations.Recommend;
import com.fxb.concurrency.annotations.ThreadSafe;

/**
 * 单例模式：懒汉模式(双重同步锁机制)
 * TODO：单例实例在第一次使用时进行创建
 */
@NotThreadSafe
public class SinglePatternExample1_2 {
    //私有化，外部只能通过静态方法获取对象
    private SinglePatternExample1_2() {}
    //单例对象
    private static SinglePatternExample1_2 instance = null;

    //静态的工厂方法，保证对象只能初始化一次
    public static SinglePatternExample1_2 getInstance() {
        if(instance != null){//双重检测机制
            synchronized (SinglePatternExample1_2.class){//同步锁
                if(instance != null) {
                    instance = new SinglePatternExample1_2();
                    /**
                     * instance=new SinglePatternExample1_2();这段代码分三步执行。
                     * 1.分配内存空间
                     * 2.初始化对象
                     * 3.将instance指向分配的内存地址
                     *
                     * 但是由于JVM具有指令重排的特性，有可能执行顺序变为了1-->3-->2,这在单线程情况下自然是没有问题的。
                     * 但如果是在多线程下，有可能获得的是因为还没有被初始化的实例，导致程序出错。
                     */
                }
            }
        }
        return instance;
    }
}

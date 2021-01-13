package com.fxb.concurrency.annotations.singleton;

import com.fxb.concurrency.annotations.NotRecommend;
import com.fxb.concurrency.annotations.NotThreadSafe;
import com.fxb.concurrency.annotations.ThreadSafe;

/**
 * 单例模式：懒汉模式
 * TODO：单例实例在第一次使用时进行创建
 */
@ThreadSafe
@NotRecommend
public class SinglePatternExample1_1 {
    //私有化，外部只能通过静态方法获取对象
    private SinglePatternExample1_1() {}
    //单例对象
    private static SinglePatternExample1_1 instance = null;
    //静态的工厂方法，保证对象只能初始化一次
    public  static SinglePatternExample1_1 getInstance() {
        if(instance != null){
            instance = new SinglePatternExample1_1();
        }
        return instance;
    }
}

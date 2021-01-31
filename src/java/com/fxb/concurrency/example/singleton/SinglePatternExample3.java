package com.fxb.concurrency.example.singleton;

import com.fxb.concurrency.annotations.ThreadSafe;

/**
 * 单例模式：枚举实现-最推荐
 */
@ThreadSafe
public class SinglePatternExample3 {
    //私有化，外部只能通过静态方法获取对象
    private SinglePatternExample3() {}

    public static SinglePatternExample3 getInstance(){
        return Singleton.INSTANCE.getSingleton();
    }
    private enum Singleton{
        INSTANCE;
        //如果打算自定义自己的方法，那么必须在enum实例序列的最后添加一个分号。
        //而且 Java 要求必须先定义 enum 实例
        private SinglePatternExample3 singleton;

        //JVM保证这个方法绝对只被调用一次
        Singleton(){
            singleton = new SinglePatternExample3();
        }
        public SinglePatternExample3 getSingleton(){
            return singleton;
        }
    }
}

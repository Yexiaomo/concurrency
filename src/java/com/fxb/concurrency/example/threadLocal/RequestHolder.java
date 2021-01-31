package com.fxb.concurrency.example.threadLocal;

public class RequestHolder {
    private final static ThreadLocal<Long> requstHolder = new ThreadLocal<>();

    public static void set(Long id){
        requstHolder.set(id);
    }
    public static Long get(){
        return requstHolder.get();
    }
    public static void remove(){
        requstHolder.remove();
    }


}

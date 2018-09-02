package com.mmall.concurrency.example.singleon;


import com.mmall.concurrency.annoations.NotThreadSafe;


/*
    懒汉模式
    单例实例在第一次使用时进行创建
 */
@NotThreadSafe
//多线程可能new多个实例
public class SingleonExample1 {

    //私有构造函数
    private SingleonExample1(){

    }

    //单例对象
    private static SingleonExample1 instance = null;

    //静态的工厂方法
    public static SingleonExample1 getInstance(){

        if(instance == null){
            instance = new SingleonExample1();
        }
        return instance;
    }
}

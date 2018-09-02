package com.mmall.concurrency.example.singleon;


import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;


/*
    饿汉模式
    单例实例在类装载时进行创建
    保证构造时没有过多的处理，并且肯定会被使用
    否则性能不高，资源浪费
 */
@ThreadSafe
public class SingleonExample2 {

    //私有构造函数
    private SingleonExample2(){

    }

    //单例对象
    private static SingleonExample2 instance = new SingleonExample2();

    //静态的工厂方法
    public static SingleonExample2 getInstance(){

        return instance;
    }
}

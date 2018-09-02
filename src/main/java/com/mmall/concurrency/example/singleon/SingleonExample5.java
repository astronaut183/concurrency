package com.mmall.concurrency.example.singleon;


import com.mmall.concurrency.annoations.NotRecommend;
import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;


/*
    懒汉模式  -》双重同步锁单例模式
    单例实例在第一次使用时进行创建
 */


@ThreadSafe
@NotRecommend
//性能开销
public class SingleonExample5 {

    //私有构造函数
    private SingleonExample5(){

    }

    //1、memory = allocate() 分配对象的内存空间
    //2、ctorInstance() 初始化对象
    //3、instance = memory 设置instance指向刚分配的内存

    //JVM和cpu优化，发生了指令重排

    //1、memory = allocate() 分配对象的内存空间
    //3、instance = memory 设置instance指向刚分配的内存
    //2、ctorInstance() 初始化对象



    //单例对象   volatile + 双重检测机制  ->  禁止指令重排
    private volatile static SingleonExample5 instance = null;

    //静态的工厂方法
    public static synchronized SingleonExample5 getInstance(){

        if(instance == null){  //双重检测机制                      //B    ->1
                synchronized (SingleonExample5.class){ //同步锁
                    if(instance == null){
                        instance = new SingleonExample5();       //A    ->3
                    }
                }
        }
        return instance;
    }
}

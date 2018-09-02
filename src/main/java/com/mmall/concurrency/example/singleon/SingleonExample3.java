package com.mmall.concurrency.example.singleon;


import com.mmall.concurrency.annoations.NotRecommend;
import com.mmall.concurrency.annoations.NotThreadSafe;
import com.mmall.concurrency.annoations.ThreadSafe;


/*
    懒汉模式
    单例实例在第一次使用时进行创建
 */
@ThreadSafe
@NotRecommend
//性能开销
public class SingleonExample3 {

    //私有构造函数
    private SingleonExample3(){

    }

    //单例对象
    private static SingleonExample3 instance = null;

    //静态的工厂方法
    public static synchronized SingleonExample3 getInstance(){

        if(instance == null){
            instance = new SingleonExample3();
        }
        return instance;
    }
}

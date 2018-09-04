package com.mmall.concurrency.example.singleon;


import com.mmall.concurrency.annoations.ThreadSafe;


/**
 * 枚举模式：最安全
 */
@ThreadSafe
public class SingleonExample7 {

    //私有构造函数
    private SingleonExample7(){

    }

    public static SingleonExample7 getInstance(){
        return Singleon.INSTANCE.getInstance();
    }

    private enum Singleon{
        INSTANCE;

        private SingleonExample7 singleon;


        //JVM保证这个方法绝对只调用一次    enumConstantDirectory方法
        //反复调用？
        Singleon(){
            singleon = new SingleonExample7();
        }

        public SingleonExample7 getInstance(){
            return singleon;
        }
    }
}

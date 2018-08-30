package com.mmall.concurrency.example.atomic;

import com.mmall.concurrency.annoations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@ThreadSafe
public class AtomicExcaple5 {

    private static AtomicIntegerFieldUpdater<AtomicExcaple5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExcaple5.class,"count");

    @Getter
    public volatile int count = 100;

    public static void main(String args[]){
        AtomicExcaple5 excaple5 = new AtomicExcaple5();

        if(updater.compareAndSet(excaple5,100,120)){
            log.info("update success 1, {}", excaple5.getCount());
        }

        if(updater.compareAndSet(excaple5,100,120)){
            log.info("update success 2, {}", excaple5.getCount());
        }else{
            log.info("update failed, {}", excaple5.getCount());
        }
    }

    public static AtomicIntegerFieldUpdater<AtomicExcaple5> getUpdater() {
        return updater;
    }

    public static void setUpdater(AtomicIntegerFieldUpdater<AtomicExcaple5> updater) {
        AtomicExcaple5.updater = updater;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

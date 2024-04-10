package com.sfox;

import org.junit.jupiter.api.Test;

public class TreadLocalTest {
    @Test
    public void testThreadLocalSetAndGet(){
        // 提供一个 ThreadLocal 对象
        ThreadLocal tl = new ThreadLocal();

        //开启两个线程
        new Thread(()->{
            tl.set("李星云");
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        },"black").start();

        new Thread(()->{
            tl.set("张子凡");
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
            System.out.println(Thread.currentThread().getName() + ": " + tl.get());
        },"white").start();
    }
}

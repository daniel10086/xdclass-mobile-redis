package com.xdclass.mobile.xdclassmobileredis;

import java.util.concurrent.atomic.AtomicInteger;

public class A {

    public native static void c();
    public static void a(){
        System.out.println("enter method a");
    }

    public static void b(){
        a();
        System.out.println("enter method b");
    }

    public static void main(String[] args) {
        b();
        System.out.println("enter method main");
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.compareAndSet(1,2);
    }
}
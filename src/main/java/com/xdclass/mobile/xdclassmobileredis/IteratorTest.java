package com.xdclass.mobile.xdclassmobileredis;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Vector;

public class IteratorTest {

    public static void main(String[] args) {
        Vector<String> v = new Vector<>();
        for (int i = 0; i < 100000; i++) {
            v.add("" + i);
        }

        Iterator<String> iterator = v.iterator();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                while (iterator.hasNext()) {
                    String next = null;
                    try{
                        next = iterator.next();
                    }catch (NoSuchElementException e){
                        System.out.println("1111");
                    }
                    iterator.remove();
                }
            }).start();
        }
    }
}
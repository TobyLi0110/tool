package com.nan.t;

import java.lang.ref.SoftReference;

public class SoftTest {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        SoftReference<Person>[] p = new SoftReference[10000];
        for (int i = 0; i < p.length; i++) {
            p[i] = new SoftReference<Person>(new Person("name" + i, i));
        }

        // 测试
        System.out.println(p[1].get());
        System.out.println(p[4].get());
        // 通知系统进行回收
        System.gc();
        System.runFinalization();

        System.out.println("---------------");
        System.out.println(p[1].get());
        System.out.println(p[4].get());
    }
}

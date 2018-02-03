package com.nan.t;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakTest {

    public static void main(String[] args) {
        /*String str = new String("JAVA讲义");
        // String str = "JAVA讲义"; 这种创建是在常量池中
        // 创建一个如引用对象 指向 str对象
        WeakReference<String> wr = new WeakReference<String>(str);
        str = null;
        // 输出
        System.out.println(wr.get());// JAVA讲义
        // 强制垃圾回收
        System.gc();
        System.out.println(wr.get());// null
*/        
        
        Object obj = new Object();
        ReferenceQueue<Object> refQueue = new ReferenceQueue<Object>();
        WeakReference<Object> weakRef = new WeakReference<Object>(obj, refQueue);
        System.out.println(weakRef.get());
        System.out.println(refQueue.poll());
        obj = null;
        System.gc();
        System.out.println(weakRef.get());
        System.out.println(refQueue.poll());
    }

}

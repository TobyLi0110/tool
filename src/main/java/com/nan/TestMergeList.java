package com.nan;

import java.util.ArrayList;
import java.util.List;

public class TestMergeList {

    public static void main(String[] args) {
     // 定义集合1
        List<String> list1 = new ArrayList<String>();
        list1.add("a1");
        list1.add("a2");
        list1.add("a3");
        System.out.println("集合1内容：" + list1);
        // 定义集合2
        List<String> list2 = new ArrayList<String>();
        list2.add("b1");
        list2.add("b2");
        list2.add("b3");
        System.out.println("集合2内容：" + list2);

        List<String> list = new ArrayList<String>();
        // 将集合1的内容全添加到集合中
        list.addAll(list1);
        // 将集合2的内容全添加到集合中
        list.addAll(list2);
        System.out.println("现在集合内容：" + list);
    }

}

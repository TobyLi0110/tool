package com.nan;

import java.util.ArrayList;
import java.util.List;

public class ConditionTest {

    public static void main(String[] args) {
        List<String> lists = new ArrayList<String>();
        lists.add("1");
        lists.add("2");
        lists.add("3");
        lists.add("4");
        lists.add("5");
        for(String str:lists){
            System.out.println(str);
        }
        String s = "2";
        System.out.println(s.equals(11));
    }

}

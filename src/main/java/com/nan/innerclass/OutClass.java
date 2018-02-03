package com.nan.innerclass;

import java.util.HashMap;

public class OutClass {
    public static class innerClass {
        private HashMap<String, String> map = new HashMap<String, String>();
        public innerClass() {
            System.out.println("innerClass");
            System.out.println(map);
        }
        public void operate(){
            map.put("1", "1");
        }
    }

    public static void main(String[] args) {
        // outClass a = new OutClass();
        innerClass b = new innerClass();
        b.operate();
        innerClass c = new innerClass();
    }
}

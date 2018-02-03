package com.nan.excel;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {

    public static void main(String[] args) throws IOException {
        StringBuffer sb= new StringBuffer("");
        FileReader reader = null;
        try {
            reader = new FileReader("E://押品管理优化//押品管理优化//押品管理优化相关sql//tempemail.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(reader);
        String str = null;
        while((str = br.readLine()) != null) {
            String[]arr  = str.split("\\|");
              System.out.println(arr[0]+"-"+arr[1]);
        }
        br.close();
        reader.close();
    }

}

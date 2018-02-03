package com.nan;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class IntegerTest {
    public static void main(String[] args) {
        /*int x=1;  
        int y=2;  
        int z=5;  
        System.out.println(x+"的二进制表示为："+Integer.toBinaryString(x)+"最左边开始数起连续的0的个数为："+Integer.numberOfLeadingZeros(x));  
        System.out.println(y+"的二进制表示为："+Integer.toBinaryString(y)+"最左边开始数起连续的0的个数为："+Integer.numberOfLeadingZeros(y));  
        System.out.println(z+"的二进制表示为："+Integer.toBinaryString(z)+"最左边开始数起连续的0的个数为："+Integer.numberOfLeadingZeros(z));  
        
        int i = 1;
        i <<= 16;
        System.out.println(i);*/
        
        
        
        
       /* static {
            int scale = unsafe.arrayIndexScale(int[].class);
            if ((scale & (scale - 1)) != 0)
                throw new Error("data type scale not a power of two");
            shift = 31 - Integer.numberOfLeadingZeros(scale);
        }

        private long checkedByteOffset(int i) {
            if (i < 0 || i >= array.length)
                throw new IndexOutOfBoundsException("index " + i);

            return byteOffset(i);
        }

        private static long byteOffset(int i) {
            return ((long) i << shift) + base;
        }*/
        
      System.out.println((1 << 16));
        System.out.println((1 << 16) - 1);
      
        System.out.println(0&((1 << 16) - 1));
        /*Field f;
        try {
            f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);  
            Unsafe unsafe = (Unsafe) f.get(null);  
            int base = unsafe.arrayBaseOffset(int[].class);
            int scale = unsafe.arrayIndexScale(int[].class);
            
            int shift = 31 - Integer.numberOfLeadingZeros(scale);
            System.out.println(base);
            System.out.println(scale);
            System.out.println(shift);
            System.out.println(((long) 1 << shift) + base);
            System.out.println(1 << 16);
            int sszie = 1;
            sszie = sszie << 1;//sszie <<= 1;
            System.out.println(sszie);
            
            16
            4
            2
            262144
        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } //Internal reference  
        catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
        
    }
}

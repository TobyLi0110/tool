package com.nan.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MapUtil {
    public static void main(String[] args) {
        Raw a = new Raw("raw_user", "raw_pass");
        Target t = new Target("target_user", "target_pass");
        String param = "username:user;password:pass";
        System.out.println(a.getUsername() + "---" + a.getPassword());
        String[] params = param.split(";");
        if (params != null && params.length > 0) {
            for (int i = 0; i < params.length; i++) {
                String[] values = params[i].split(":");
                if (values != null && values.length == 2) {
                    String raw = values[0];
                    String target = values[1];
                    Field rawf;
                    Field targetf;

                    String tmp  = raw;
                    char[] cs = raw.toCharArray();
                    cs[0] -= 32;
                    raw = String.valueOf(cs);

                    char[] css = target.toCharArray();
                    css[0] -= 32;
                    target = String.valueOf(css);

                    try {
                        System.out.println(a.getClass().getDeclaredField(tmp).getType());
                        Method m3 = t.getClass().getDeclaredMethod("get"+target);
                        Method m = a.getClass().getDeclaredMethod("set" + raw,a.getClass().getDeclaredField(tmp).getType());
                        m.invoke(a, m3.invoke(t));
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (NoSuchMethodException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (NoSuchFieldException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println(a.getUsername() + "---" + a.getPassword());
    }
}

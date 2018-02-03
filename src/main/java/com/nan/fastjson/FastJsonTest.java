package com.nan.fastjson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class FastJsonTest {

    public static void main(String[] args) {
        
        /*{
            "bizType": "B005",
            "serviceName": "JuXinLi",
            "methodName": "jxlAddressList",
            "params": {
                "name": "张三",
                "idCard": "340103198007018430",
                "mobile": "15625273902"
            }
        }*/
        
        /*JSONObject json = new JSONObject();
        json.put("bizType", "B005");
        json.put("serviceName", "JuXinLi");
        json.put("methodName", "jxlAddressList");
        JSONObject sonjson = new JSONObject();
        sonjson.put("name", "张三");
        sonjson.put("idCard", "340103198007018430");
        sonjson.put("mobile", "15625273902");
        json.put("params", sonjson);
        System.out.println(json);*/
        
        
        
        /*String str = "{\"code\":\"200\",\"flag\":\"S\",\"msg\":\"请求成功\",\"data\":{\"idCard\":\"429006188523589856\",\"mobile\":\"18736429007\",\"phone_nums\":[{\"phone_num\":\"1824567898\",\"Name\":\"老爸\"},{\"phone_num\":\"1824567898\",\"Name\":\"姑姑\"},{\"phone_num\":\"1824567898\",\"Name\":\"张三\"}]}}";
        JSONObject obj = (JSONObject) JSON.parseObject(str);
        JSONObject jarr1  = obj.getJSONObject("data");
        JSONArray jarr  = jarr1.getJSONArray("phone_nums");
        for (Iterator<Object> iterator = jarr.iterator(); iterator.hasNext();) { 
            JSONObject job = (JSONObject) iterator.next(); 
            System.out.println(job.get("phone_num")+"-"+job.get("Name")); 
        }*/
        /*JSONObject ja1rr  = obj.getJSONObject("a");
        JSONArray jarr  = ja1rr.getJSONArray("phones");
        for (Iterator<Object> iterator = jarr.iterator(); iterator.hasNext();) { 
            JSONObject job = (JSONObject) iterator.next(); 
            System.out.println(job.get("phone_num")+"-"+job.get("Name")); 
        }*/
        
      
      List<Map<String, Object>> a = new ArrayList<Map<String, Object>>();
      Map<String, Object> a1 = new HashMap<String, Object>();
      a1.put("11","北京");
      a.add(a1);
      
      Map<String, Object> a2 = new HashMap<String, Object>();
      a2.put("13","河北");
      
      
      List<Map<String, Object>> a22 = new ArrayList<Map<String, Object>>();
      Map<String, Object> a21 = new HashMap<String, Object>();
      a21.put("1301","石家庄");
      a22.add(a21);
      Map<String, Object> a223 = new HashMap<String, Object>();
      a223.put("1302","保定");
      a22.add(a223);
      
      a2.put("childCity",a22);
      
      a.add(a2);
      
       
        String actual = JSON.toJSONString(a);
        System.out.println(actual);
    }

}

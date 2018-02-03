package com.nan.rocketmq_test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * 
 * @author toby
 * @description:
 * @project_name:rocketmq-test
 * @file_name:URLEncodeTest.java
 * @date:2017年10月9日 上午10:56:44
 */
public class URLEncodeTest {

	public static void main(String[] args) {
		String content = null;
		try {
			content = URLEncoder.encode("touna测试", "utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(content + "---");
	}

}

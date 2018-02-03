package com.nan.rocketmqtest.dto;


/**
 * 
 * @author saga
 * @description:测试类
 * @project_name:org.rocketmq.dto
 * @file_name:TestDto.java
 * @date:2017年7月19日 上午11:36:44
 */
public class TestTag /*extends BaseMessage */{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 12312312312312312l;

	private int userId;

	private String userName;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}

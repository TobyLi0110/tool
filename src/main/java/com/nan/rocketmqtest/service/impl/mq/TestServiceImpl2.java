package com.nan.rocketmqtest.service.impl.mq;

import com.nan.rocketmqtest.dto.TestDto;
import com.nan.rocketmqtest.dto.TestTag;
import com.touna.infructure.annotations.ConsumerTag;
import com.touna.infructure.annotations.ConsumerToppic;
import com.touna.infructure.service.base.AbstractBaseToppic;

/**
 * 
 * @author saga
 * @description:测试类
 * @project_name:org.rocketmq.service
 * @file_name:TestService.java
 * @date:2017年7月19日 下午2:52:03
 */
@ConsumerToppic("TopicTest1")
public class TestServiceImpl2 /*extends AbstractBaseToppic<TestDto>*/  {

	/*@Override
	public void onApplicationLisitener(TestDto t) {
		System.out.println("TopicTest2收到消息=================>" + new String(t.formateObejct()));
	}*/

	@ConsumerTag("TagB")
	public void hello(TestTag tag) {
		System.out.println("TopicTest2=============>接口调用--hello收到消息=================>" + new String(tag.toString()));
	}

}

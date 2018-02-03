package com.nan.rocketmqtest.service.impl.mq;

import com.nan.rocketmqtest.dto.TestTag;

/**
 * 
 * @author saga
 * @description:测试类
 * @project_name:org.rocketmq.service
 * @file_name:TestService.java
 * @date:2017年7月19日 下午2:52:03
 */
/*@ConsumerToppic("TopicTest2")*/
public class TestServiceImpl /*extends AbstractBaseToppic<TestDto>*/ {

	/*@Override
	public void onApplicationLisitener(TestDto t) {
		
		System.out.println("TopicTest1收到消息=================>" + new String(t.formateObejct()));
	}*/

/*	@ConsumerTag("TagA")*/
	public void TagALisitener(TestTag t) {
		System.out.println("TopicTagA收到消息=================>" + new String(t.toString()));
	}

	

	public static void main(String[] args) {
//		System.out.println(DelayTimeConstant.DELAY_FIRST_LEVEL);
	}
}

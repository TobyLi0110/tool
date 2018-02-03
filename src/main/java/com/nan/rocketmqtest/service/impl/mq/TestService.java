package com.nan.rocketmqtest.service.impl.mq;

import com.nan.rocketmqtest.dto.TestTag;
import com.touna.infructure.annotations.ProducerParam;
import com.touna.infructure.annotations.ProducerToppic;
import com.touna.infructure.dto.base.BaseMessage;
import com.touna.infructure.service.base.ProducerToppicInterface;

/**
 * 
 * @author saga
 * @description:测试接口类
 * @project_name:com.touna.infructure.service.impl
 * @file_name:TestService.java
 * @date:2017年7月20日 下午5:10:27
 */
@ProducerToppic("TopicTest1")
public interface TestService extends ProducerToppicInterface {
	@ProducerParam(tag = "TagB")
	public void test(TestTag testTag);
}

package com.nan.rocketmqtest.service.impl.mq;

import com.nan.rocketmqtest.dto.TestTag;
import com.touna.infructure.annotations.ProducerParam;
import com.touna.infructure.annotations.ProducerToppic;
import com.touna.infructure.dto.base.BaseMessage;
import com.touna.infructure.service.base.ProducerToppicInterface;

@ProducerToppic("TopicTest2")
public interface TestService3 extends ProducerToppicInterface {
	@ProducerParam(tag = "TagA")
	public void hello1(TestTag tag);
}

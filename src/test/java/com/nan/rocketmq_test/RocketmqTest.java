package com.nan.rocketmq_test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nan.rocketmqtest.dto.TestTag;
import com.nan.rocketmqtest.service.impl.mq.TestService3;

public class RocketmqTest {

  public static void main(String[] args) {
    ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    
    
    TestService3 testService3 = (TestService3)context.getBean("testService3");
    TestTag tag = new TestTag();
//    tag.setBody("aa".getBytes());
    testService3.hello1(tag);
    while(true){}
    
  }

}

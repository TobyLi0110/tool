package com.nan.rocketmqtest;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.alibaba.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

public class Consumer01 {
  public static void main(String[] args) {
    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("touna-test-consumer");
    consumer.setNamesrvAddr("10.0.4.127:9876");
    consumer.setClientIP("10.0.4.127");
    //consumer.setMessageModel(MessageModel.BROADCASTING);
    consumer.setInstanceName("touna-test-consumer-03");
    try {
      // 订阅PushTopic下Tag为push的消息
      consumer.subscribe("TOPIC_MULTI_CONSUMER", "*");
      // 程序第一次启动从消息队列头取数据
      //consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
      consumer.registerMessageListener(new MessageListenerConcurrently() {
        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
            ConsumeConcurrentlyContext Context) {
          /*
           * Message msg = list.get(0); System.out.println(msg.toString());
           */
          MessageExt messageExt = list.get(0);
          System.out.println("==============msg:\t" + new String(messageExt.getBody()));
          return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
      });
      consumer.start();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

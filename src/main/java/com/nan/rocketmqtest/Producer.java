package com.nan.rocketmqtest;

import java.nio.charset.Charset;
import java.util.Date;


import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;
import com.nan.rocketmqtest.dto.Test;
import com.nan.rocketmqtest.dto.TestOther;

public class Producer {
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("pawn-producer1");
        /*
         * 设置productGroup， 该值不能为空， 最大长度不能超过255， 匹配正则表达式^[%|a-zA-Z0-9_-]+$， 不能等于"DEFAULT_PRODUCER"
         * 
         * 
         * 特殊ProductGroup "CLIENT_INNER_PRODUCER"
         * 启动一个groupName为CLIENT_INNER_PRODUCER的DefaultMQProducer， 用于将消费失败的消息发回broker,消息的topic格式
         */



        producer.setNamesrvAddr("10.0.4.127:9876");
        try {
            producer.start();
            int i = 13;

            TestOther other = new TestOther();
            other.setUserName("test json message17");

            Test t = new Test();
            t.setApplyId(177741);
            t.setApplyNo("201709180000131715A");
            t.setCode(0);
            t.setPaymentTime(1505980898215l);

            /*LoanSuccessDTO loanSuccessDTO = new LoanSuccessDTO();
            loanSuccessDTO.setApplyId(177741);
            loanSuccessDTO.setApplyNo("201709180000131715A");
            loanSuccessDTO.setPaymentTime(new Date());
            loanSuccessDTO.setCode(0);*/
            while (true) {
                i++;
                /*loanSuccessDTO.setCode(i);*/
                Message msg = new Message("Lost_Message", "lost_test", JSON.toJSONString("").getBytes(Charset.forName("UTF-8")));
                SendResult result = producer.send(msg);

                /*
                 * msg = new Message("PushTopic", "push", "2", "Just for test.".getBytes());
                 * 
                 * result = producer.send(msg); System.out.println("id:" + result.getMsgId() +
                 * " result:" + result.getSendStatus());
                 */

                // msg = new Message("PullTopic", "pull", "1", "Just for test.".getBytes());
                // result = producer.send(msg);
                System.out.println("id:" + result.getMsgId() + " result:" + result.getSendStatus());
                if (i % 3 == 0) {
                    Thread.sleep(20000);
                }
                if(i == 130){
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // producer.shutdown();
        }
    }
}

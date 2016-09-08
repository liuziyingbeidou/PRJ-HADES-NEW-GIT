package com.zjs.conf;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.exception.MQClientException;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.zjs.mq.MqTopicConsumer;
import com.zjs.mq.MyDefaultMQPushConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: hades-ia-mq
 * @ClassName: com.zjs.conf
 * @Date: 2016/7/21
 * @Authoe: 郑文
 * @Description: mq配置类
 */
@Configuration
@ConfigurationProperties(prefix = MqConfig.PREFIX)
public class MqConfig extends DefaultMQPushConsumer {

    public static final String PREFIX = "mq";

    private String consumerGroup;
    private int consumeThreadMax;
    private int consumeThreadMin;
    private String namesrvAddr;
    private String instanceName;
    private String topicName;

    @Autowired
    MqTopicConsumer mqTopicConsumer;

    @Bean(initMethod = "start", destroyMethod = "shutdown")
    public MyDefaultMQPushConsumer myDefaultMQPushConsumer() throws MQClientException {
        Map<String, String> subscribe = new HashMap<String, String>();
        subscribe.put(topicName, "*");

        MyDefaultMQPushConsumer myDefaultMQPushConsumer = new MyDefaultMQPushConsumer(consumerGroup,
                instanceName, namesrvAddr, subscribe, mqTopicConsumer);
        myDefaultMQPushConsumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
        myDefaultMQPushConsumer.setConsumeThreadMax(5);
        myDefaultMQPushConsumer.setConsumeThreadMin(1);
        return myDefaultMQPushConsumer;
    }

    @Override
    public String getConsumerGroup() {
        return consumerGroup;
    }

    @Override
    public void setConsumerGroup(String consumerGroup) {
        this.consumerGroup = consumerGroup;
    }

    @Override
    public int getConsumeThreadMax() {
        return consumeThreadMax;
    }

    @Override
    public void setConsumeThreadMax(int consumeThreadMax) {
        this.consumeThreadMax = consumeThreadMax;
    }

    @Override
    public int getConsumeThreadMin() {
        return consumeThreadMin;
    }

    @Override
    public void setConsumeThreadMin(int consumeThreadMin) {
        this.consumeThreadMin = consumeThreadMin;
    }

    @Override
    public String getNamesrvAddr() {
        return namesrvAddr;
    }

    @Override
    public void setNamesrvAddr(String namesrvAddr) {
        this.namesrvAddr = namesrvAddr;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Override
    public String getInstanceName() {
        return instanceName;
    }

    @Override
    public void setInstanceName(String instanceName) {
        this.instanceName = instanceName;
    }
}

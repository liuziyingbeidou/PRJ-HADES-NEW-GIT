package com.zjs.mq;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.client.exception.MQClientException;

import java.util.Map;

/**
 * @ProjectName: hades-ia-mq
 * @ClassName: com.zjs.conf
 * @Date: 2016/7/21
 * @Authoe: 郑文
 * @Description: mq重写类
 */
public class MyDefaultMQPushConsumer extends DefaultMQPushConsumer {
    public MyDefaultMQPushConsumer(String consumerGroup,
                                   String instanceName,
                                   String namesrvAddr,
                                   Map<String, String> subscribe,
                                   MessageListenerConcurrently messageListenerConcurrently) throws MQClientException {
        super(consumerGroup);
        setNamesrvAddr(namesrvAddr);
        setInstanceName(instanceName);
        for (Map.Entry<String, String> entry : subscribe.entrySet()) {
            subscribe(entry.getKey(), entry.getValue());
        }
        registerMessageListener(messageListenerConcurrently);
    }
}

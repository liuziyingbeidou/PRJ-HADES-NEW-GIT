package com.zjs.mq;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.message.MessageExt;
import com.zjs.dto.SignMqParam;
import com.zjs.exception.BusinessException;
import com.zjs.exception.LaterDealBusinessException;
import com.zjs.service.task.AcceptSignTaskService;

/**
 * @ProjectName: hades-ia-mq
 * @ClassName: com.zjs.mq
 * @Date: 2016/7/21
 * @Authoe: 郑文
 * @Description: mq主体入口类
 */
@Service
public class MqTopicConsumer implements MessageListenerConcurrently {

    Logger logger = LoggerFactory.getLogger(MqTopicConsumer.class);

    @Autowired
    AcceptSignTaskService acceptSignTaskService;


    /**
     * 默认msgs里只有一条消息，可以通过设置consumeMessageBatchMaxSize参数来批量接收消息
     */
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> msgs, ConsumeConcurrentlyContext context) {
    	long startTime = System.currentTimeMillis();
        MessageExt msg = msgs.get(0);

        String messageJson = new String(msg.getBody());
        logger.info("message body:" + messageJson);
        
        // 接收mq消息
        SignMqParam signMqParam = JSON.parseObject(messageJson, SignMqParam.class);
        
        if (signMqParam == null) {
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        }
        
        try {
			// 生成签收任务
        	boolean isSuccess = acceptSignTaskService.insertSignWorkerTask(signMqParam);
        	
        	if(!isSuccess){
        		logger.info("##mq消费：工作单号【" + signMqParam.getWbCode() + "】签收数据插入任务表失败！");
        	}
        	
		} catch (LaterDealBusinessException e) {
            logger.error("##mq消费：工作单号为【" + signMqParam.getWbCode() + "】，执行完成，返回Later：" + e.getMessage());
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        } catch (BusinessException e) {
            logger.error("##mq消费：工作单号为【"+signMqParam.getWbCode()+"】，执行完成，返回Success："+e.getMessage());
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        } catch (Exception e) {
            logger.error("##mq消费：工作单号为【"+signMqParam.getWbCode()+"】，执行完成，返回Later："+e.getMessage());
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
        
        logger.info("##mq消费：工作单号为【"+signMqParam.getWbCode()+"】，执行完成，返回Success");
        long endTime = System.currentTimeMillis();
        logger.info("mq消费：耗时统计：MqTopicConsumer ->工作单号【 " + signMqParam.getWbCode() + "】耗时【" + (endTime - startTime) + "】ms");
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }

}
package com.zj.service;

import com.zj.config.GrowingIoProperties;
import com.zj.request.EventMessageRequest;
import io.growing.sdk.java.GrowingAPI;
import io.growing.sdk.java.dto.GIOEventMessage;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Set;


public class GrowingioServiceImpl implements GrowingioService {
    
    private static final Logger logger = LoggerFactory.getLogger(GrowingioServiceImpl.class);
    
    @Override
    public void sendEventMessage(EventMessageRequest request){
        try{
            if(StringUtils.isEmpty(request.getEventKey()) && StringUtils.isEmpty(request.getUserId())){
                return;
            }
            GIOEventMessage.Builder builder = new GIOEventMessage.Builder()
                    .eventTime(System.currentTimeMillis())
                    .eventKey(request.getEventKey())
                    .loginUserId(request.getUserId());
            Set<Map.Entry<String, Object>> entries = request.getEventVariableMap().entrySet();
            for(Map.Entry<String, Object> entry : entries){
                String key = entry.getKey();
                Object value = entry.getValue();
                if(value != null){
                    if(value instanceof String){
                        builder.addEventVariable(key, ((String) value));
                    }else if(value instanceof Long){
                        builder.addEventVariable(key, ((Long) value).toString());
                    }else if(value instanceof Integer){
                        builder.addEventVariable(key, ((Integer) value));
                    }else if(value instanceof Double){
                        builder.addEventVariable(key, ((Double) value));
                    }else if(value instanceof BigDecimal){
                        builder.addEventVariable(key, ((BigDecimal) value).doubleValue());
                    }else {
                        logger.warn("not support event variable value type:{}", key);
                    }
                }
                
            }
            //事件行为消息体
            GIOEventMessage eventMessage = builder.build();
            //上传事件行为消息到服务器,底层阻塞队列异步处理
            GrowingAPI.send(eventMessage);
        }catch (Exception e){
            logger.error("send growingio event message error：{}" , e.getMessage(),e);
        }
        
    }
    
}
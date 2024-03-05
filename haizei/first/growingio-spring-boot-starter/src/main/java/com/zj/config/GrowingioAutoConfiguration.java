package com.zj.config;

import com.zj.constants.GrowingioConstant;
import com.zj.service.GrowingioService;
import com.zj.service.GrowingioServiceImpl;
import io.growing.sdk.java.utils.ConfigUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Properties;

@Configuration
@EnableConfigurationProperties(GrowingIoProperties.class)
@Component("growingioAutoConfiguration")
public class GrowingioAutoConfiguration{
    
    private static final Logger logger = LoggerFactory.getLogger(GrowingioAutoConfiguration.class);
    
    @Autowired
    protected GrowingIoProperties growingioProperties;
    
    @Bean
    public GrowingioService growingioService(){
        return new GrowingioServiceImpl();
    }
    
    public void checkProperties() {
        //校验并开始检查是否配置必填的属性
        if(StringUtils.isEmpty(growingioProperties.getApiHost())){
            throw new RuntimeException("growing properties api.host must be defined");
        }
        if(StringUtils.isEmpty(growingioProperties.getProjectId())){
            throw new RuntimeException("growing properties project.id must be defined");
        }
    }
    
    
    /**
     * 页面初始化执行函数
     */
    @PostConstruct
    private void init(){
        this.checkProperties();
        //初始化配置
        this.initGrowingioApiProperties();
    }
    
    private void initGrowingioApiProperties() {
        Properties properties = new Properties();
        properties.setProperty(GrowingioConstant.API_HOST_KEY, growingioProperties.getApiHost());
        properties.setProperty(GrowingioConstant.PROJECT_ID_KEY, growingioProperties.getProjectId());
        properties.setProperty(GrowingioConstant.SEND_MSG_INTERVAL_KEY, growingioProperties.getSendMsgInterval().toString());
        properties.setProperty(GrowingioConstant.SEND_MSG_THREAD_KEY, growingioProperties.getSendMsgThread().toString());
        properties.setProperty(GrowingioConstant.MSG_STORE_QUEUE_SIZE_KEY, growingioProperties.getMsgStoreQueueSize().toString());
        properties.setProperty(GrowingioConstant.COMPRESS_KEY, growingioProperties.getCompress().toString());
        properties.setProperty(GrowingioConstant.LOGGER_LEVEL_KEY, growingioProperties.getLoggerLevel());
        properties.setProperty(GrowingioConstant.LOGGER_IMPL_KEY, growingioProperties.getLoggerImplemention());
        properties.setProperty(GrowingioConstant.RUN_MODE_KEY, growingioProperties.getRunMode());
        properties.setProperty(GrowingioConstant.CONNECTION_TIMEOUT_KEY, growingioProperties.getConnectionTimeout().toString());
        properties.setProperty(GrowingioConstant.READ_TIMEOUT_KEY, growingioProperties.getReadTimeout().toString());
        //通过SDK中的这个API可以避免使用properties文件
        ConfigUtils.init(properties);
        System.out.println("zhixing");
        logger.info("init load growingio starter api properties success,url:{},runmode:{},enable:{}",
                growingioProperties.getApiHost(),growingioProperties.getRunMode(),growingioProperties.getEnable());
    }
    
    
}
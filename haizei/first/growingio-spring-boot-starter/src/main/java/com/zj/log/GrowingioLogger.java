package com.zj.log;

import io.growing.sdk.java.logger.GioLoggerInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GrowingioLogger implements GioLoggerInterface {

    private static final Logger logger = LoggerFactory.getLogger(GrowingioLogger.class);
    
    @Override
    public void debug(String s) {
        logger.info("测试阶段日志输出:{}", s);
    }
    
    @Override
    public void error(String s) {
        logger.error("测试阶段日志输出:{}", s);
    }
}
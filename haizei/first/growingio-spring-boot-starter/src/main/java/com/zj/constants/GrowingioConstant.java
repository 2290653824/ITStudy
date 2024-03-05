package com.zj.constants;

public class GrowingioConstant {
    
    /**
     * 项目采集端地址
     */
    public static final String API_HOST_KEY = "api.host";
    
    /**
     * 项目ID
     */
    public static final String PROJECT_ID_KEY = "project.id";
    
    /**
     * 消息发送间隔时间,单位ms（默认 100）
     */
    public static final String SEND_MSG_INTERVAL_KEY = "send.msg.interval";
    
    /**
     * 消息发送线程数量,默认为3
     */
    public static final String SEND_MSG_THREAD_KEY = "send.msg.thread";
    
    /**
     * 消息队列大小
     */
    public static final String MSG_STORE_QUEUE_SIZE_KEY = "msg.store.queue.size";
    
    /**
     * 数据压缩 false:不压缩, true:压缩 不压缩可节省cpu，压缩可省带宽
     */
    public static final String COMPRESS_KEY = "compress";
    
    /**
     * 日志输出级别（debug | error）
     */
    public static final String LOGGER_LEVEL_KEY = "logger.level";
    
    /**
     * 自定义日志输出实现类
     */
    public static final String LOGGER_IMPL_KEY = "logger.implemention";
    
    /**
     * 运行模式，test：仅输出消息体，不发送消息，production：发送消息
     */
    public static final String RUN_MODE_KEY = "run.mode";
    
    /**
     * http 连接超时时间，默认2000ms
     */
    public static final String CONNECTION_TIMEOUT_KEY = "connection.timeout";
    
    /**
     * http 连接读取时间，默认2000ms
     */
    public static final String READ_TIMEOUT_KEY = "read.timeout";
    
    
}
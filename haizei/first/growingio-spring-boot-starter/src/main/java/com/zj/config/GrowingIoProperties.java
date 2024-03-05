package com.zj.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zhengjian
 * @date 2024-03-04 22:16
 */
@ConfigurationProperties(prefix = GrowingIoProperties.GROWINGIO_PREFIX)
@Data
public class GrowingIoProperties {

    /**
     * 默认前缀
     */
    public static final String GROWINGIO_PREFIX = "growingio";

    /**
     * 项目采集端地址
     */
    private String apiHost;

    /**
     * 项目ID
     */
    private String projectId;

    /**
     * 消息发送间隔时间,单位ms（默认 100）
     */
    private Integer sendMsgInterval = 100;

    /**
     * 消息发送线程数量,默认为3
     */
    private Integer sendMsgThread = 3;

    /**
     * 消息队列大小
     */
    private Integer msgStoreQueueSize = 500;

    /**
     * 数据压缩 false:不压缩, true:压缩 不压缩可节省cpu，压缩可省带宽
     */
    private Boolean compress = true;

    /**
     * 日志输出级别（debug | error）
     */
    private String loggerLevel = "debug";

    /**
     * 自定义日志输出实现类
     */
    private String loggerImplemention = "com.zj.log.GrowingioLogger";

    /**
     * 运行模式，test：仅输出消息体，不发送消息，production：发送消息
     */
    private String runMode = "test";

    /**
     * http 连接超时时间，默认2000ms
     */
    private Integer connectionTimeout = 2000;

    /**
     * http 连接读取时间，默认2000ms
     */
    private Integer readTimeout = 2000;

    /**
     * 是否启用:自定义属性:标识是否启用，默认为不启用，非growing io 官方属性
     */
    private Boolean enable = false;

}
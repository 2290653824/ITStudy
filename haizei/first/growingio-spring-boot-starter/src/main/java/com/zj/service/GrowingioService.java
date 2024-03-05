package com.zj.service;

import com.zj.request.EventMessageRequest;

/**
 * @author zhengjian
 * @date 2024-03-04 23:00
 */
public interface GrowingioService {

    void sendEventMessage(EventMessageRequest request);
}

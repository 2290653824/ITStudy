package com.zj.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class EventMessageRequest implements Serializable {
    private static final long serialVersionUID = 892840357641768298L;
    
    private String eventKey;

    private String eventNumValue;
    private String userId;

    private Map<String,Object> eventVariableMap;
    
    public EventMessageRequest(String eventKey, String userId, 
            Map<String, Object> eventVariableMap) {
        this.eventKey = eventKey;
        this.userId = userId;
        this.eventVariableMap = eventVariableMap;
    }

    public EventMessageRequest(String eventKey, String eventNumValue, String userId,
                               Map<String, Object> eventVariableMap) {
        this.eventKey = eventKey;
        this.eventNumValue = eventNumValue;
        this.userId = userId;
        this.eventVariableMap = eventVariableMap;
    }
}
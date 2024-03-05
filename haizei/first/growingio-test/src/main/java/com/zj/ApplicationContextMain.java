package com.zj;

import com.zj.config.GrowingIoProperties;
import com.zj.request.EventMessageRequest;
import com.zj.service.GrowingioService;
import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashMap;

/**
 * @author zhengjian
 * @date 2024-03-05 21:53
 */
@SpringBootApplication
public class ApplicationContextMain {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ApplicationContextMain.class, args);
        GrowingioService growingioService = context.getBean("growingioService", GrowingioService.class);
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId","wahah");
        EventMessageRequest eventMessageRequest = new EventMessageRequest("删除用户","zhengjian",map);
        growingioService.sendEventMessage(eventMessageRequest);


    }
}

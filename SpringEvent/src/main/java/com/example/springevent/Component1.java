package com.example.springevent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:00 2022/7/16
 */
@Component
public class Component1 {

    @Autowired
    private ApplicationEventPublisher context;

    public void register(){
        System.out.println("有用户注册，Component1发送注册事件");
        context.publishEvent(new UserRegisterEvent(this));
    }
}

package com.example.springevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 19:00 2022/7/16
 */
@Component
@Slf4j
public class Component2 {
    @EventListener
    public void listenVvent(UserRegisterEvent event){
        System.out.println("Component2监听到注册事件: " + event.toString());
        System.out.println("Component2向数据库中插入数据");
    }
}

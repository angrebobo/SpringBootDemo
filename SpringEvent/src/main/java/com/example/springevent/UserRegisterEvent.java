package com.example.springevent;

import org.springframework.context.ApplicationEvent;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 18:59 2022/7/16
 */
public class UserRegisterEvent extends ApplicationEvent {
    public UserRegisterEvent(Object source) {
        super(source);
    }
}

package com.example.starter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
// 读取配置文件中的属性
@ConfigurationProperties(prefix = "http")
public class HttpProperties {

    private String url = "www.baidu.com";
}

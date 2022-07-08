package com.example.aop.advise;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:59 2022/7/8
 */
@Aspect
@Component
@Order(0)
public class LogAspectAdvice {
    @Pointcut("@annotation(com.example.aop.annotation.PermissionAnnotation)")
    private void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("====doBefore方法进入了====");

        // 获取签名
        Signature signature = joinPoint.getSignature();
        // 获取切入的包名
        String declaringTypeName = signature.getDeclaringTypeName();
        // 获取即将执行的方法名
        String funcName = signature.getName();
        System.out.println("即将执行方法为: " + funcName + "，属于" + declaringTypeName + "包");

        // 也可以用来记录一些信息，比如获取请求的 URL 和 IP
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        // 获取请求 URL
        String url = request.getRequestURL().toString();
        // 获取请求 IP
        String ip = request.getRemoteAddr();
        System.out.println("用户请求的url为：" + url + "，ip地址为：" + ip);
    }
}

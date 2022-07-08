package com.example.aop.advise;

import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author: HuangSiBo
 * @Description:
 * @Data: Created in 14:02 2022/7/8
 */
@Aspect
@Component
@Order(2)
public class PermissionCheckAdvice {

    @Pointcut("@annotation(com.example.aop.annotation.PermissionAnnotation)")
    private void permissionCheck(){}

    @Around("permissionCheck()")
    public Object permissionCheckAction(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("-----第二个切面，校验权限-----" + System.currentTimeMillis());

        Object[] args = joinPoint.getArgs();
        System.out.println(Arrays.toString(args));
        Long id = ((JSONObject) args[0]).getLong("id");
        String name = ((JSONObject) args[0]).getString("name");
        System.out.println("id2->>>>>>>>>>>>>>>>>>>>>>" + id);
        System.out.println("name2->>>>>>>>>>>>>>>>>>>>>>" + name);

        if(!"admin".equals(name)){
            return JSONObject.parseObject("{\"message\":\"illegal name\",\"code\":403}");
        }

        return joinPoint.proceed();
    }
}

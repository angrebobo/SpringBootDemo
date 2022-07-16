package com.example.aop.Cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CarMethodInterceptor implements MethodInterceptor {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new CarMethodInterceptor());
        Car car = (Car) enhancer.create();
        car.speed();
        car.torque();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("Object: " + o.getClass());
        System.out.println("Method: " + method.getName());
        System.out.println("MethodProxy: " + methodProxy.getClass());
        if (method.getName().equals("speed"))
            System.out.println("速度测试开始...");
        if (method.getName().equals("torque"))
            System.out.println("扭矩测试开始...");

        Object ret = methodProxy.invokeSuper(o, objects);
        System.out.println("ret = " + ret);
        if (method.getName().equals("speed"))
            System.out.println("速度测试结束！");
        if (method.getName().equals("torque"))
            System.out.println("扭矩测试结束！");
        return ret;
    }
}

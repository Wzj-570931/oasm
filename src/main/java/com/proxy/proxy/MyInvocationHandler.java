package com.proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
    UserSayProxy target;
    public Object getInstance(UserSayProxy target){
        this.target=target;
        Class<? extends UserSayProxy> aClass = this.target.getClass();
        return Proxy.newProxyInstance(aClass.getClassLoader(),aClass.getInterfaces(),this);
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("这是执行方法前");
        Object result = method.invoke(this.target,args);
        System.out.println("执行方法后");
        return result;
    }
}

package com.oasm.mapper;

import com.oasm.dao.DbMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyFactoryBean implements FactoryBean, InvocationHandler {
    Class clazz;
    public MyFactoryBean(Class clazz){
        this.clazz = clazz;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method method1 = proxy.getClass().getInterfaces()[0].getMethod(method.getName(), int.class);
        Select select = method1.getAnnotation(Select.class);
        System.out.println(select.value()[0]);
        //System.out.println("1111111");
        return null;
    }

    @Override
    public Object getObject() throws Exception {
        Class[] targetClass = new Class[]{DbMapper.class};
        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(), targetClass, this);
        return o;
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}

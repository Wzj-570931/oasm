package com.proxy.test;

import com.proxy.interface_package.UserInter;
import com.proxy.proxy.MyInvocationHandler;
import com.proxy.proxy.UserSayProxy;
import com.proxy.target.UserImpl;

public class Test {
    public static void main(String[] args) {
        /*MyTarget obj = new MyProxy();
        obj.say();*/
        //System.out.println(obj.name);
        /*UserImpl  user = new UserImpl();
        UserSayProxy userSayProxy = new UserSayProxy(user);
        userSayProxy.say();*/
        MyInvocationHandler invocationHandler = new MyInvocationHandler();
        UserInter instance = (UserInter) invocationHandler.getInstance(new UserSayProxy(new UserImpl()));
        instance.say();
    }
}

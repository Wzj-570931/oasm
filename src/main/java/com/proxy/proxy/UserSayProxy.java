package com.proxy.proxy;

import com.proxy.interface_package.UserInter;
import com.proxy.target.UserImpl;

public class UserSayProxy implements UserInter {
    UserImpl user;
    public UserSayProxy(UserImpl user){
        this.user = user;
    }
    public void say() {
        user.say();
        System.out.println("UserSayProxy say");
    }
}

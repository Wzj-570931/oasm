package com.proxy.target;

import com.proxy.interface_package.UserInter;

public class UserImpl implements UserInter {
    public void say() {
        //AbstractQueuedSynchronizer
        //HashMap
        System.out.println("this is target say");
    }
}

package com.proxy.proxy;

import com.proxy.target.MyTarget;

public class MyProxy  extends MyTarget {
    private String name="proxy field";
    @Override
    public void say() {
        super.say();
        System.out.println("Proxy method");
    }
}

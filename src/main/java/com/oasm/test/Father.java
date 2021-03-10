package com.oasm.test;

public class Father {
    protected Integer getVal(){
        return 2;
    }
}

class Son extends Father{
    public Integer getVal(){
        this.say();
        return 1;
    }
    public void say(){}
}

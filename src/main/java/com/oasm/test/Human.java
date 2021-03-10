package com.oasm.test;

public class Human extends Man{
    {
        System.out.println("human 代码块");
    }
    public Human(){
        System.out.println("human 构造方法");
    }

    @Override
    public void say() {
        System.out.println("子类方法");
    }

    public static void main(String[] args) {
        Man man = new Human();
        man.say();
    }
}
class Man{
    {
        System.out.println("man 代码块");
    }
    public Man(){
        System.out.println("man 构造方法");
    }
    public void say(){
        System.out.println("父类方法");
    }
}
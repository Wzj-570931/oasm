package com.oasm.test;

public class TestParent {
    public static void main(String[] args) {
        Base c = new Child();
        System.out.println(c.a);
    }
}
class Base{
    public int a = 10;
    public Base(){
        printName();
    }
    public void printName(){
        System.out.println("base");
    }
}
class Child extends Base{
    public int a = 12;
    public Child(){
        printName();
    }
    public void printName(){
        System.out.println("child");
    }


}
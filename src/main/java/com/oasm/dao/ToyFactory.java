package com.oasm.dao;

import org.springframework.stereotype.Component;

@Component
public class ToyFactory implements Factory{
    public void getName(String name) {
        System.out.println("ToyFactory:getName");
    }
}

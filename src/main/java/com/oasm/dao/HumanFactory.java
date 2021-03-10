package com.oasm.dao;

import com.oasm.annotation.Entity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository("humanFactory")
@Primary
@Entity(value = "123",name = "345")
public class HumanFactory implements Factory{
    @Entity(value = "456")
    public void getName(String name) {
        System.out.println("HumanFactory:getName="+name);
    }
}

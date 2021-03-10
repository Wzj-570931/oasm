package com.oasm.dao;

import com.oasm.annotation.Entity;

@Entity(value = "123",name = "345")
public interface Factory {
    void getName( String name);
}

package com.oasm.service;

import com.oasm.dao.HumanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Service;

@Service("factory1")
public class MyFactoryBean implements FactoryBean {
    public Object getObject() throws Exception {
        return new HumanFactory();
    }

    public Class<?> getObjectType() {
        return null;
    }

    public boolean isSingleton() {
        return false;
    }
}

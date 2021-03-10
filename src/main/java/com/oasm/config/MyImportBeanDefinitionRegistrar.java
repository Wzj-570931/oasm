package com.oasm.config;

import com.oasm.dao.DbMapper;
import com.oasm.mapper.MyFactoryBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(DbMapper.class);
        GenericBeanDefinition beanDefinition = (GenericBeanDefinition) builder.getBeanDefinition();
        beanDefinition.setBeanClass(MyFactoryBean.class);
        beanDefinition.getConstructorArgumentValues().addGenericArgumentValue("com.oasm.dao.DbMapper");
        beanDefinitionRegistry.registerBeanDefinition("dbMapper",beanDefinition);
    }
}

package com.oasm.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(value = "com.oasm")
@EnableAspectJAutoProxy(proxyTargetClass = false)
public class ConfigStart {

}

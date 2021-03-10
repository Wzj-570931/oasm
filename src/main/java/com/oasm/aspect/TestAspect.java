package com.oasm.aspect;

import com.oasm.dao.Factory;
import com.oasm.dao.HumanFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {
    @Pointcut("execution(* com.oasm.dao.HumanFactory.*(..))")
    private void logPoint(){
        System.out.println("log of logPoint");
    }

    @DeclareParents(value = "com.oasm.dao.*", defaultImpl = HumanFactory.class)
    public static Factory factory;

    @Before("logPoint()")
    public void before(){
        System.out.println("this is before advise");
    }

    @Around("logPoint()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for (int i = 0; i < args.length; i++) {
            args[i] += " nihao";
        }
        System.out.println("a");
        pjp.proceed(args);
        System.out.println("b");
    }
}

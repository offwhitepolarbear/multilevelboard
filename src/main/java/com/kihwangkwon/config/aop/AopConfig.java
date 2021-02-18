package com.kihwangkwon.config.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AopConfig{

    @Before("execution(* com.kihwangkwon.main.controller.MainController.*(..))")
    public void doSomethingBefore() {
        log.info("AOP Test : Before ");
    }

    @After("execution(* com.kihwangkwon.main.controller.MainController.*(..))")
    public void doSomethingAfter() {
        log.info("AOP Test : After");
    }
    
}
package com.scut.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect
public class MyAspect5 {
    //前置通知
    //@Before("execution(public void com.scut.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
    //匹配list和delete方法
    /*
    @Before("execution(* com.scut.service.impl.DeptServiceImpl.list(..))||"+
            "execution(* com.scut.service.impl.DeptServiceImpl.delete(..))")
    public void before(){
        log.info("MyAspect5 -> before ...");
    }

     */
    @Before("@annotation(com.scut.anno.LogOperation)")
    public void before(){
        log.info("MyAspect5 -> before ...");
    }




}

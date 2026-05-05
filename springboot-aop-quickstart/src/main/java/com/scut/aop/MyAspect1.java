package com.scut.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
@Component
public class MyAspect1 {
    @Pointcut("execution(* com.scut.service.impl.*.*(..))")
    private void pt(){}
    //前置通知
    @Before("pt()")
    public void before(){
        log.info("before……");
    }
    //环绕通知-目标方法运行之前、后运行
    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("around……before……");

        Object result = pjp.proceed();

        log.info("around……after……");
        return result;
    }

    //后置通知-目标方法运行之后运行
    @After("pt()")
    public void after(){
        log.info("after……");
    }

    //返回通知-目标方法运行之后运行，如果出现异常不会运行
    @AfterReturning("pt()")
    public void afterReturning(){
        log.info("afterReturning……");
    }
    //异常后通知-目标方法运行之后运行，只有出现异常不会运行
    @AfterThrowing("pt()")
    public void afterThrowing(){
        log.info("afterThrowing……");
    }




}

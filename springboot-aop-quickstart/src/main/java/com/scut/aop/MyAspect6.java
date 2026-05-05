package com.scut.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class MyAspect6 {
    //前置通知
    @Before("execution(* com.scut.service.impl.*.*(..))")
    public void before(JoinPoint joinPoint){
        log.info("before……");
        //1、获取目标对象
        Object target=joinPoint.getTarget();
        log.info("获取目标对象：{}",target);
        //2、获取目标类
        String className=joinPoint.getTarget().getClass().getName();
        log.info("获取目标类：{}",className);
        //3、获取目标方法
        String methodName=joinPoint.getSignature().getName();
        log.info("获取目标方法：{}",methodName);
        //4、获取参数
        Object[] args=joinPoint.getArgs();
        log.info("获取目标方法参数：{}", Arrays.toString(args));
    }
    //环绕通知-目标方法运行之前、后运行
    @Around("execution(* com.scut.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("around……before……");

        Object result = pjp.proceed();

        log.info("around……after……");
        return result;
    }

}

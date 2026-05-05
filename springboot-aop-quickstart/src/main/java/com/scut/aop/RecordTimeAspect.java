package com.scut.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
//@Aspect
@Component
public class RecordTimeAspect {
    @Around("execution(* com.scut.service.impl.*.*(..))")
    public Object recordTime(ProceedingJoinPoint pjp) throws Throwable {
        //记录方法运行的开始时间
        long begin=System.currentTimeMillis();
        //执行原始的方法
        Object result= pjp.proceed();

        //记录方法运行的结束时间，记录耗时
        long end=System.currentTimeMillis();
        log.info("方法 {} 运行耗时：{}ms",pjp.getSignature(),end-begin);

        return result;

    }
}

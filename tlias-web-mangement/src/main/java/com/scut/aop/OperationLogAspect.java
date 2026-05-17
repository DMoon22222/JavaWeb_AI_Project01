package com.scut.aop;

import com.scut.mapper.OperateLogMapper;
import com.scut.pojo.OperateLog;
import com.scut.utils.CurrentHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.scut.anno.Log)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long costTime = endTime - startTime;

        Integer currentUserId = getCurrentUserId();
        if (currentUserId == null) {
            log.warn("当前用户ID为空，跳过操作日志记录: {}.{}",
                    joinPoint.getTarget().getClass().getName(),
                    joinPoint.getSignature().getName());
            return result;
        }

        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(currentUserId);
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(String.valueOf(result));
        operateLog.setCostTime(costTime);

        log.info("操作日志: {}", operateLog);

        try {
            operateLogMapper.insert(operateLog);
        } catch (Exception e) {
            log.error("操作日志写入失败，但不影响主业务", e);
        }

        return result;
    }

    private Integer getCurrentUserId() {
        return CurrentHolder.getCurrentId();
    }
}

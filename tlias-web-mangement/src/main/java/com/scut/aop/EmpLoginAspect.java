package com.scut.aop;

import com.scut.mapper.EmpLoginMapper;
import com.scut.pojo.Emp;
import com.scut.pojo.EmpLoginLog;
import com.scut.pojo.LoginInfo;
import com.scut.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
public class EmpLoginAspect {

    private final EmpLoginMapper empLoginMapper;

    public EmpLoginAspect(EmpLoginMapper empLoginLogMapper) {
        this.empLoginMapper = empLoginLogMapper;
    }

    @Around("execution(* com.scut.controller.LoginController.login(..))")
    public Object recordLoginLog(ProceedingJoinPoint joinPoint) throws Throwable {

        long begin = System.currentTimeMillis();
        LocalDateTime loginTime = LocalDateTime.now();

        String username = null;
        String password = null;
        Short isSuccess = 0;
        String jwt = null;

        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0 && args[0] instanceof Emp) {
            Emp emp = (Emp) args[0];
            username = emp.getUsername();
            password = emp.getPassword();
        }

        Object resultObj = null;

        try {
            resultObj = joinPoint.proceed();

            if (resultObj instanceof Result) {
                Result result = (Result) resultObj;

                // 这里默认 code == 1 表示成功
                if (result.getCode() != null && result.getCode() == 1) {
                    isSuccess = 1;

                    Object data = result.getData();
                    if (data instanceof LoginInfo) {
                        LoginInfo loginInfo = (LoginInfo) data;
                        jwt = loginInfo.getToken();
                    }
                } else {
                    isSuccess = 0;
                }
            }

            return resultObj;

        } catch (Throwable e) {
            isSuccess = 0;
            throw e;
        } finally {
            long end = System.currentTimeMillis();
            long costTime = end - begin;

            EmpLoginLog empLoginLog = new EmpLoginLog();
            empLoginLog.setUsername(username);
            empLoginLog.setPassword(password);
            empLoginLog.setLoginTime(loginTime);
            empLoginLog.setIsSuccess(isSuccess);
            empLoginLog.setJwt(jwt);
            empLoginLog.setCostTime(costTime);

            try {
                empLoginMapper.insert(empLoginLog);
            } catch (Exception ex) {
                log.error("保存登录日志失败: {}", ex.getMessage(), ex);
            }
        }
    }
}

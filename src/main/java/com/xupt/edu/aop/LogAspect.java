package com.xupt.edu.aop;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LogAspect {
     private final Log log = LogFactory.getLog(getClass());

    @Before("execution(* com.xupt.edu.controlller.UserController.signin(..))")
    public void loginLogAspect(JoinPoint joinPoint){
        String methodName=joinPoint.getSignature().toShortString();
        String args=joinPoint.getArgs().toString();
        log.info("---Before method "+methodName+" invoke, param:" +args+"---");
    }

}

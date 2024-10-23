package com.ashu.SpringBootRest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    public static final Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);

    //return type, qualified class name(including package name).method-name(args) this  is the format executed below in @Before()
    //here @Before is ADVICE
    //here ("execution(* com.ashu.SpringBootRest.service.JobService.*(..))") is point cut
    @Before("execution(* com.ashu.SpringBootRest.service.JobService.getJob(..)) || execution(* com.ashu.SpringBootRest.service.JobService.updateJob(..)) ")
    public void logMethodCalled(JoinPoint jp){
        LOGGER.info("Method Called" + " " + jp.getSignature().getName());
    }

    @After("execution(* com.ashu.SpringBootRest.service.JobService.getJob(..)) || execution(* com.ashu.SpringBootRest.service.JobService.updateJob(..)) ")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Method executed" + " " + jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.ashu.SpringBootRest.service.JobService.getJob(..)) || execution(* com.ashu.SpringBootRest.service.JobService.updateJob(..)) ")
    public void logMethodCrash(JoinPoint jp){
        LOGGER.info("Method crashed" + " " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.ashu.SpringBootRest.service.JobService.getJob(..)) || execution(* com.ashu.SpringBootRest.service.JobService.updateJob(..)) ")
    public void logMethodSuccess(JoinPoint jp){
        LOGGER.info("Method Success" + " " + jp.getSignature().getName());
    }

}

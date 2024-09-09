package com.tarun.learn_spring_aop.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class PerformanceTrackingAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Around("execution(* com.tarun.learn_spring_aop.*.*.*(..))")
    public Object findExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTimeMills= System.currentTimeMillis();
        Object returnValue = proceedingJoinPoint.proceed();
        long stopTimeMills= System.currentTimeMillis();

        long executionTimeMills= stopTimeMills-startTimeMills;
        logger.info("Around Aspect - {} Method executed in {} ms",proceedingJoinPoint,executionTimeMills);
        return returnValue;
    }
}

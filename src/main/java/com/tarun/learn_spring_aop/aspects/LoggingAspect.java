package com.tarun.learn_spring_aop.aspects;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(getClass());
    //
    @Before("execution(* com.tarun.learn_spring_aop.*.*.*(..))")
    public void logMethodBeforeExecution(JoinPoint joinPoint){
        logger.info("Before Aspect is - {} is called with arguments: {}"
                ,joinPoint
                ,joinPoint.getArgs());
    }
    @After("execution(* com.tarun.learn_spring_aop.*.*.*(..))")
    public void logMethodCallAfterExecution(JoinPoint joinPoint){
        logger.info("After Aspect is called - {}" ,joinPoint);
    }

    @AfterThrowing(
            pointcut="execution(* com.tarun.learn_spring_aop.*.*.*(..))",
            throwing = "exception"
    )
    public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception){
        logger.info("AfterThrowing Aspect is called - {} has throwing exception {}"
                ,joinPoint,exception);
    }


    @AfterReturning(
            pointcut="execution(* com.tarun.learn_spring_aop.*.*.*(..))",
            returning = "resultValue"
    )
    public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue){
        logger.info("AfterReturning Aspect is called - {} has returned {}"
                ,joinPoint,resultValue);
    }
}

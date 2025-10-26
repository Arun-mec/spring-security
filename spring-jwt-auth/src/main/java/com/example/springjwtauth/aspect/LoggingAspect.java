package com.example.springjwtauth.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // com.example.springjwtauth.service.StateService.getAllStates(..) - Only for the method
    // com.example.springjwtauth.service.StateService.*() - All methods inside StateService class
    // com.example.springjwtauth.service.*.*(..) - All methods in all service package
    // com.example.springjwtauth.*.*.*(..) - All methods in the base package

    // Executed before the method execution
    @Before("execution(* com.example.springjwtauth.service.StateService.getAllStates(..))")
    public void addStartLog() {
        System.out.println("Logging aspect is called, Method - started[Before log]");
    }

    // Executed after the method execution
    @After("execution(* com.example.springjwtauth.service.StateService.getAllStates(..))")
    public void addEndLog() {
        System.out.println("Logging aspect is called, Method - ended[After log]");
    }

    // Executed throughout the method execution
    @Around("execution(* com.example.springjwtauth.service.StateService.*())")
    public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Executed in the starting
        System.out.println("Logging aspect is called - Method started[Around log]");

        //Jointpoint(Class method) execution
        Object result = proceedingJoinPoint.proceed();

        // Executed in the starting
        System.out.println("Logging aspect is called - Method ended[Around log]");
        return result;
    }
}

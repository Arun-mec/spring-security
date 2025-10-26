package com.example.springjwtauth.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    // com.example.springjwtauth.service.StateService.getAllStates(..) - Only for the method
    // com.example.springjwtauth.service.StateService.*() - All methods inside StateService class
    // com.example.springjwtauth.service.*.*(..) - All methods in all service package
    // com.example.springjwtauth.*.*.*(..) - All methods in the base package


    // Pointcut Designator
    // execution(* com.example.springjwtauth.service.StateService.*()) - Executed for matching methods[Specifically for methods]
    // within(com.example.springjwtauth.service.StateService) - Executed for all methods within this service[Specifically for classes]
    // target(com.example.springjwtauth.service.StateService) - Executed when the instance of StateService is created
    //                                                          Methods are executed
    // @within(org.springframework.stereotype.Service) - Executed for all classes with @Service annotation
    // @annotation(org.springframework.stereotype.Service) - Executed for all methods with @PostMapping annotation
    // @target(org.springframework.stereotype.Service) - Executed when the instance of StateService is created
    //                                                   Methods are executed with the given target Annotation

    // Named point cut
    @Pointcut("execution(* com.example.springjwtauth.service.StateService.*())")
    public void pointcutExpn() {}

    @Pointcut("within(com.example.springjwtauth.service.StateService)")
    public void withInPointcutExpn() {}

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
    @Around("pointcutExpn()")
    public Object aroundLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // Executed in the starting
        System.out.println("Logging aspect is called - Method started[Around log]");

        //Jointpoint(Class method) execution
        Object result = proceedingJoinPoint.proceed();

        // Executed in the starting
        System.out.println("Logging aspect is called - Method ended[Around log]");
        return result;
    }

    @AfterReturning("withInPointcutExpn()")
    public void returningLog() {
        System.out.println("Method execution completed - [Afterreturning log]");
    }

    @AfterThrowing("pointcutExpn()")
    public void throwingLog() {
        System.out.println("Method thrown error - [Afterthrowing log]");
    }

}

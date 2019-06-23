package com.imooc.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/*@Component
@Aspect*/
public class TimeAspect {
    @Around(" execution (* com.imooc.web.controller.UserController.*(..))")
    public Object handleControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aspect start");
        Object[] args = pjp.getArgs();
        for (Object arg:args) {
            System.out.println(arg);
        }

        Long start=new Date().getTime();
        Object proceed = pjp.proceed();

        System.out.println("timeAspect :"+(new Date().getTime()-start));
        System.out.println("aspect end");
        return proceed;
    }
}

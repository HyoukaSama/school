package com.hyouka.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice {
    public void bofore() {
        System.out.println("前置通知");
    }

    public void afterReturning() {
        System.out.println("后置通知通知（如果出现异常不会调用）");
    }

    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕通知之前");
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕通知之后");
        return proceed;
    }

    public void afterException() {
        System.out.println("出现异常");
    }

    public void after() {
        System.out.println("后置通知");
    }
}

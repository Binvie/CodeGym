package com.example.book_management.AOP;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
    public static int count = 0;

    @After("execution(* com.example.book_management.controller.BookController.*(..))")
    public void count() {
        count++;
        System.out.println("number traffic " + count);
    }

    @After("execution(* com.example.book_management.controller.BookController.*(..)))")
    public void writeLog(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName());
    }
}

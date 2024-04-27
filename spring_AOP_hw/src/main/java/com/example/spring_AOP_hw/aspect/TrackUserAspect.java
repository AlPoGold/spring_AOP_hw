package com.example.spring_AOP_hw.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

@Aspect
public class TrackUserAspect {
    @Around("execution(* com.example.spring_AOP_hw.*.*(..))")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        return pjp.proceed();
    }

    @Around("@annotation(trackUserAction)")
    public Object log(ProceedingJoinPoint pjp, TrackUserAction trackUserAction) throws Throwable {
        return pjp.proceed();
    }


    @AfterReturning(value="@annotation(trackUserAction)", returning = "returnedValue")
    public void log(JoinPoint joinPoint, Object returnedValue, TrackUserAction trackUserAction){
        String method = trackUserAction.method();
        try(FileWriter fileWriter = new FileWriter("log.txt", true)){
            StringBuilder sb = new StringBuilder();
            sb.append(LocalDateTime.now()).append(" : ").append(method).append("\n");
            System.out.println(sb.toString());
            fileWriter.write(sb.toString());
            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

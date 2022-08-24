package com.mabdullaev.market.aspect;

import com.mabdullaev.market.service.BenchMarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
@RequiredArgsConstructor
public class ControllerLogAspect {
    private final BenchMarkService benchMarkService;

    @Around("@within(Benchmark)||@annotation(Benchmark)")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Instant start = Instant.now();
        Object response = joinPoint.proceed();
        Instant end = Instant.now();
        benchMarkService.logElapsed(joinPoint.getTarget().getClass().getSimpleName(), Duration.between(start, end).toMillis());
        return response;
    }

    @Before("execution(* com.mabdullaev.market.controllers.*.*(..))")
    public void logBefore(JoinPoint joinPoint){
        log.info("{} {}",joinPoint.getTarget().getClass().getSimpleName(), Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(",", "[","]")));
    }

}

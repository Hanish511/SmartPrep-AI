package com.hanish.smart_prep.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceTrackingAspect {

    private static final Logger log = LoggerFactory.getLogger(PerformanceTrackingAspect.class);

    @Around("execution(* com.hanish.smart_prep.service.AiGenerationService.generateFlashcards(..))")
    public Object trackAiGenerationTime(ProceedingJoinPoint joinPoint) throws Throwable {
        Long startTime = System.currentTimeMillis();
        log.info("Calling Google Gemini AI...");
        Object result = joinPoint.proceed();
        Long endTime = System.currentTimeMillis();
        Long duration = endTime - startTime;

        log.info("AI generation is complete. It took exactly {} milliseconds.", duration);
        return result;
    }

}

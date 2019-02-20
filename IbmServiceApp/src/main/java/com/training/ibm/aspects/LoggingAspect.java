package com.training.ibm.aspects;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;


/**
 * Class based on Spring AOP which logs the TRACE level messages at the start and end of 
 * all methods in a class which is annotated with #Loggable.
 * 
 * Ref: http://www.tothenew.com/blog/logging-with-spring-aop-and-custom-annotations-in-java-application/
 * Ref: https://github.com/stayendraverma/aop-logger
 * 
 */
@Component
@Aspect
@Slf4j
public class LoggingAspect {


    @Around(value = "@within(Loggable) || @annotation(Loggable)")
    public Object traceLogMethod(ProceedingJoinPoint joinPoint) throws Throwable {

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Loggable loggableMethod = signature.getMethod().getAnnotation(Loggable.class);
        Loggable loggableClass = joinPoint.getTarget().getClass().getAnnotation(Loggable.class);
        boolean logParams = loggableMethod != null ? loggableMethod.params() : loggableClass.params();
        
        StringBuilder logMessage = buildLogMessageMethodArgs(joinPoint, logParams);
        log.info("Method start2: " + logMessage.toString());

        // Call the method
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object retVal = joinPoint.proceed();
        stopWatch.stop();

        boolean logReturnValue = loggableMethod != null ? loggableMethod.returnValue() : loggableClass.returnValue();
        logMessage = buildLogMessageReturnValue(joinPoint, stopWatch, retVal, logReturnValue);
        log.info("Method end2: " + logMessage.toString());
        
        // Return the return value of the method
        return retVal;
    }



    private StringBuilder buildLogMessageMethodArgs(ProceedingJoinPoint joinPoint, boolean logParams) {
        StringBuilder logMessage = new StringBuilder();
        logMessage.append(joinPoint.getTarget().getClass().getCanonicalName()).append("->");
        logMessage.append(joinPoint.getSignature().getName());
        
        if (logParams) {
	        logMessage.append("(");
	
	        Object[] args = joinPoint.getArgs();
	        for (Object arg : args) {
	            logMessage.append(arg).append(", ");
	        }
	        if (args.length > 0) {
	            logMessage.deleteCharAt(logMessage.length() - 2);
	        }
	        logMessage.append(")");
        }
        
        return logMessage;
    }
    
	private StringBuilder buildLogMessageReturnValue(ProceedingJoinPoint joinPoint, StopWatch stopWatch, Object retVal, boolean logReturnValue) {
		StringBuilder logMessage;
		logMessage = new StringBuilder();
		logMessage.append(joinPoint.getTarget().getClass().getCanonicalName()).append("->");
		logMessage.append(joinPoint.getSignature().getName());
		if (logReturnValue) {
			logMessage.append(" retVal = " +  retVal);
	        logMessage.append(" execution time: ");
	        logMessage.append(stopWatch.getTotalTimeMillis());
	        logMessage.append(" ms");
		}
        return logMessage;

	}
 
}


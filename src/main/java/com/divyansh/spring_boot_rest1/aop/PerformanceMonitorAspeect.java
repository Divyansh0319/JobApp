package com.divyansh.spring_boot_rest1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspeect {
	private static final Logger logger = LoggerFactory.getLogger(PerformanceMonitorAspeect.class);
	
	
	@Around("execution(com.divyansh.spring_boot_rest1.model.JobPost com.divyansh.spring_boot_rest1.service.JobService.getJobById(..))")
	public Object monitortime(ProceedingJoinPoint jp) throws Throwable {
		Long start=System.currentTimeMillis();
		Object object= jp.proceed();
		
		Long end=System.currentTimeMillis();
		logger.info("runnable time by: " + jp.getSignature().getName()+" "+(end-start));
		System.out.println(end-start);
		return object;
	}
}

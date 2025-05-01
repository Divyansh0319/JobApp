package com.divyansh.spring_boot_rest1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
	private static final Logger logger=LoggerFactory.getLogger(LoggingAspect.class);
	
	
	// return_type class_name.method_name(args)
	
	
	// for all methods
//	@Before("execution(* com.divyansh.spring_boot_rest1.service.JobService.*(..))")
//	public void logMethodCall() {
//		logger.info("logger mein aapka swagat hais");
//	}
//	
	// for specific method use joinPoint
	@Before("execution(* com.divyansh.spring_boot_rest1.service.JobService.getJobById(..)) || execution(* com.divyansh.spring_boot_rest1.service.JobService.UpdateJob(..)) ")
	public void getlogger(JoinPoint jp) {
		logger.info("method called : " + jp.getSignature().getName());
	}
	
	@After("execution(* com.divyansh.spring_boot_rest1.service.JobService.getJobById(..)) || execution(* com.divyansh.spring_boot_rest1.service.JobService.UpdateJob(..)) ")
	public void getloggerafter(JoinPoint jp) {
		logger.info("method called after : " + jp.getSignature().getName());
	}
	
	@AfterThrowing("execution(* com.divyansh.spring_boot_rest1.service.JobService.getJobById(..)) || execution(* com.divyansh.spring_boot_rest1.service.JobService.UpdateJob(..)) ")
	public void getloggeraftercrash(JoinPoint jp) {
		logger.info("method called after having issue: " + jp.getSignature().getName());
	}
	
	
	@AfterReturning("execution(* com.divyansh.spring_boot_rest1.service.JobService.getJobById(..)) || execution(* com.divyansh.spring_boot_rest1.service.JobService.UpdateJob(..)) ")
	public void getloggerafterexecuted(JoinPoint jp) {
		logger.info("method called after executed successfully: " + jp.getSignature().getName());
	}
	
}

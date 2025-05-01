package com.divyansh.spring_boot_rest1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
	private static final Logger logger = LoggerFactory.getLogger(ValidationAspect.class);
	
	@Around("execution(com.divyansh.spring_boot_rest1.model.JobPost com.divyansh.spring_boot_rest1.service.JobService.getJobById(..)) && args(postId)")
	public Object validateandupdate(ProceedingJoinPoint jp,int postId) throws Throwable {
		if(postId<0) {
			logger.info("value is negative so updating it");
			postId=-postId;
			logger.info("value updated : " + postId);
			
		}
		Object object = jp.proceed(new Object[] {postId});
		return object;
	}
}

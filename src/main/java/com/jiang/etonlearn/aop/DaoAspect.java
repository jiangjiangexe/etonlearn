package com.jiang.etonlearn.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DaoAspect {

	private static final Logger log = LoggerFactory.getLogger(DaoAspect.class);

	@Before("execution(* com.jiang.etonlearn.repository.*.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.info("zero");
	}

}

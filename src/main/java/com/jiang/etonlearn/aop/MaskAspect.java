package com.jiang.etonlearn.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Aspect
@Component
@Order(1)
public class MaskAspect {
    private static final Logger log = LoggerFactory.getLogger(MaskAspect.class);

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping() {
    }

    @Pointcut("execution(* com.jiang.etonlearn.controller.*.*.*(..))")
    public void methodPointcut() {
    }

    @Pointcut("requestMapping() && methodPointcut()")
    protected void defaultPointcut() {
    }

    /*
     * @see com.iftek.aop.AbstractAroundAspect#beforeAdivce(org.aspectj.lang. ProceedingJoinPoint, com.iftek.sys.dto.AopResult)
     */
    protected void beforeAdivce(ProceedingJoinPoint joinPoint) throws Exception {
    }

    /*
     * 將指定的欄位做資料遮蔽 EMail遮蔽：長度第2~5的字元，例如ajay@eton.tw -> a＊＊＊＊eton.tw 電話遮蔽：長度第4~7的字元，例如0989053831 -> 098＊＊＊＊831 姓名遮蔽：頭尾中間的字元，例如林義傑 -> 林*傑，宗原王子 -> 宗＊＊子
     * @see com.iftek.aop.AbstractAroundAspect#afterAdivce(org.aspectj.lang. ProceedingJoinPoint, java.lang.Object)
     */
    protected Object afterAdivce(ProceedingJoinPoint joinPoint, Object result) throws Exception {
       return result;
    }

}

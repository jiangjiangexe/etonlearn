package com.jiang.etonlearn.play;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogHandler implements InvocationHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private Object delegate;

    // 綁定要代理的物件
    public Object bind(Object delegate) {
        this.delegate = delegate;
        // 建立並傳回代理物件
        return Proxy.newProxyInstance(delegate.getClass().getClassLoader(), delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            logger.info("start");
            result = method.invoke(delegate, args);
            logger.info("end");
        } catch (Exception e) {
            logger.info("exception", e.toString());
        }
        return result;
    }
}
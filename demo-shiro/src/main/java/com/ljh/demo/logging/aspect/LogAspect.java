package com.ljh.demo.logging.aspect;

import com.ljh.demo.common.utils.HttpContextUtil;
import com.ljh.demo.logging.annotation.Log;
import com.ljh.demo.logging.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    private Long currentTime = 0L;

    private final LogService logService;

    public LogAspect(LogService logService) {
        this.logService = logService;
    }

    @Pointcut("@annotation(com.ljh.demo.logging.annotation.Log)")
    public void poincut() {

    }

    @Around("poincut()")
    public Object logAround(ProceedingJoinPoint point) {
        Object result = null;
        currentTime = System.currentTimeMillis();
        Method method = resoleMethod(point);
        Log log = method.getAnnotation(Log.class);
        String operate = log.operation();
        HttpServletRequest request = HttpContextUtil.getHttpServletRequest();
        try {
            result = point.proceed();
            logService.saveLog(point, method, request, operate, currentTime);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    public Method resoleMethod(ProceedingJoinPoint point) {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Class<?> clz = point.getTarget().getClass();
        Method method = getDeclaredMethod(clz, methodSignature.getName(), methodSignature.getMethod().getParameterTypes());
        if (method == null) {
            throw new IllegalStateException("无法解析目标方法: " + methodSignature.getMethod().getName());
        }
        return method;
    }

    private Method getDeclaredMethod(Class<?> clazz, String name, Class<?>... parameterTypes) {
        try {
            return clazz.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null) {
                return getDeclaredMethod(superClass, name, parameterTypes);
            }
        }
        return null;
    }
}
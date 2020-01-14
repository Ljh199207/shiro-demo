package com.ljh.demo.logging.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ljh.demo.common.entity.FebsConstant;
import com.ljh.demo.logging.entity.SystemLog;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.scheduling.annotation.Async;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

public interface LogService extends IService<SystemLog> {

    /**
     * 异步保存操作日志
     *
     * @param point     切点
     * @param method    Method
     * @param request   HttpServletRequest
     * @param operation 操作内容
     * @param start     开始时间
     */
    @Async(FebsConstant.ASYNC_POOL)
    void saveLog(ProceedingJoinPoint point, Method method, HttpServletRequest request, String operation, long start) throws InterruptedException;
}

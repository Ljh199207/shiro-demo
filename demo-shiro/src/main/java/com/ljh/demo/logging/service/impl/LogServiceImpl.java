package com.ljh.demo.logging.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ljh.demo.common.utils.AddressUtil;
import com.ljh.demo.common.utils.IPUtil;
import com.ljh.demo.logging.entity.SystemLog;
import com.ljh.demo.logging.mapper.LogMapper;
import com.ljh.demo.logging.service.LogService;
import com.ljh.demo.system.entity.User;
import org.apache.shiro.SecurityUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.*;

@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, SystemLog> implements LogService {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void saveLog(ProceedingJoinPoint point, Method method, HttpServletRequest request, String operation, long start) throws InterruptedException {
        SystemLog systemLog = new SystemLog();
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        if (user != null) {
            systemLog.setUsername(user.getUsername());
        }
        systemLog.setOperation(operation);
        //设置ip
        String ip = IPUtil.getIpAddr(request);
        systemLog.setIp(ip);
        // 设置耗时
        systemLog.setTime(System.currentTimeMillis() - start);
        // 请求的类名
        String className = point.getTarget().getClass().getName();
        // 请求的方法名
        String methodName = method.getName();
        systemLog.setMethod(className + "." + methodName + "()");
        // 请求的方法参数值
        Object[] args = point.getArgs();
        // 请求的方法参数名称
        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] paramNames = u.getParameterNames(method);
        if (args != null && paramNames != null) {
            StringBuilder params = new StringBuilder();
            params = handleParams(params, args, Arrays.asList(paramNames));
            systemLog.setParams(params.toString());
        }
        systemLog.setCreateTime(new Date());
        systemLog.setLocation(AddressUtil.getCityInfo(ip));
        Thread.sleep(6000);
        save(systemLog);
    }

    private StringBuilder handleParams(StringBuilder params, Object[] args, List asList) {
        try {
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof Map) {
                    Set set = ((Map) args[i]).keySet();
                    List<Object> list = new ArrayList<>();
                    List<Object> paramList = new ArrayList<>();
                    for (Object key : set) {
                        list.add(((Map) args[i]).get(key));
                        paramList.add(key);
                    }
                    return handleParams(params, list.toArray(), paramList);
                } else {
                    if (args[i] instanceof Serializable) {
                        Class<?> aClass = args[i].getClass();
                        try {
                            aClass.getDeclaredMethod("toString", new Class[]{null});
                            // 如果不抛出 NoSuchMethodException 异常则存在 toString 方法 ，安全的 writeValueAsString ，否则 走 Object的 toString方法
                            params.append(" ").append(asList.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i]));
                        } catch (NoSuchMethodException e) {
                            params.append(" ").append(asList.get(i)).append(": ").append(objectMapper.writeValueAsString(args[i].toString()));
                        }
                    } else if (args[i] instanceof MultipartFile) {
                        MultipartFile file = (MultipartFile) args[i];
                        params.append(" ").append(asList.get(i)).append(": ").append(file.getName());
                    } else {
                        params.append(" ").append(asList.get(i)).append(": ").append(args[i]);
                    }
                }
            }
        } catch (Exception ignore) {
            params.append("参数解析失败");
        }
        return params;
    }
}

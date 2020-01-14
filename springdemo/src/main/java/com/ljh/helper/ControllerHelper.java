package com.ljh.helper;

import com.ljh.annotation.MyRequestMapping;
import com.ljh.handle.Handler;
import com.ljh.handle.Request;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class ControllerHelper {
    /**
     * REQUEST_MAP为 "请求-处理器" 的映射
     */
    private static final Map<Request, Handler> REQUEST_MAP = new HashMap<Request, Handler>();

    static {
        Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
        if (CollectionUtils.isNotEmpty(controllerClassSet)) {
            for (Class<?> cls : controllerClassSet) {
                //暴力反射获取所有方法
                Method[] methods = cls.getDeclaredMethods();
                if (ArrayUtils.isNotEmpty(methods)) {
                    for (Method method : methods) {
                        //判断是否带RequestMapping注解
                        if (method.isAnnotationPresent(MyRequestMapping.class)) {
                            MyRequestMapping requestMapping = method.getAnnotation(MyRequestMapping.class);
                            //请求路径
                            String requestPath = requestMapping.value();
                            //请求方法
                            String requestMethod = requestMapping.method().name();

                            //封装请求和处理器
                            Request request = new Request(requestMethod, requestPath);
                            Handler handler = new Handler(cls, method);
                            REQUEST_MAP.put(request, handler);
                        }
                    }
                }

            }
        }

    }
    /**
     * 获取 Handler
     */
    public static Handler getHandler(String requestMethod, String requestPath) {
        Request request = new Request(requestMethod, requestPath);
        return REQUEST_MAP.get(request);
    }
}

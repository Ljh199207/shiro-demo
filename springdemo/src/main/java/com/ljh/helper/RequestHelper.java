package com.ljh.helper;

import com.ljh.handle.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

public class RequestHelper {

    /**
     * 获取请求参数
     */
    public static Param createParam(HttpServletRequest request) {
        Map<String, Object> paramMap = new HashMap<>();
        Enumeration<String> parameterNames = request.getParameterNames();
        //没有参数
        if (!parameterNames.hasMoreElements()) {
            return null;
        }
        //get和post参数都能获取到
        while (parameterNames.hasMoreElements()) {
            String fieldName = parameterNames.nextElement();
            String fieldValue = request.getParameter(fieldName);
            paramMap.put(fieldName, fieldValue);
        }
        return new Param(paramMap);
    }
}

package com.ljh.helper;

import com.ljh.annotation.MyAutowired;
import com.ljh.util.ReflectionUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.ArrayUtils;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Set;

public final class IocHelper {
    /**
     * 遍历bean容器所有bean的属性, 为所有带@Autowired注解的属性注入实例
     */

    static {
        //遍历bean容器里的所有bean
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (MapUtils.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                //bean的class类
                Class<?> beanClass = beanEntry.getKey();
                //bean的实例
                Object beanInstance = beanEntry.getValue();
                //暴力反射获取属性
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtils.isNotEmpty(beanFields)) {
                    for (Field field : beanFields) {
                        //判断属性是否带Autowired注解
                        if (field.isAnnotationPresent(MyAutowired.class)) {
                            //属性类型
                            Class<?> beanFieldClass = field.getType();
                            //如果beanFieldClass是接口, 就获取接口对应的实现类
                            beanFieldClass = findImplementClass(beanFieldClass);
                            //获取Class类对应的实例
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, field, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }

    public static Class<?> findImplementClass(Class<?> cls) {
        Class<?> implementClass = cls;
        Set<Class<?>> classes = ClassHelper.getClassSetBySuper(cls);
        if (CollectionUtils.isNotEmpty(classes)) {
            //获取第一个实现类
            implementClass = classes.iterator().next();
        }
        return implementClass;
    }
}

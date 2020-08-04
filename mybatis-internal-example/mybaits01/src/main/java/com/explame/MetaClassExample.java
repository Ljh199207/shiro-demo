package com.explame;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaClass;
import org.junit.Test;

public class MetaClassExample {

    @Data
    @AllArgsConstructor
    private static class Order {
        String orderNo;
        String goodsName;
    }


    @Test
    public void testMetaClass() {
        MetaClass metaClass = MetaClass.forClass(Order.class, new DefaultReflectorFactory());
        // 获取所有有Getter方法的属性名
        String[] getterNames = metaClass.getGetterNames();
        System.out.println(JSON.toJSONString(getterNames));
        // 是否有默认构造方法
        System.out.println("是否有默认构造方法：" + metaClass.hasDefaultConstructor());

    }

}

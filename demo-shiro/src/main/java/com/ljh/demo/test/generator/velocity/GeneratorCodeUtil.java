package com.ljh.demo.test.generator.velocity;

import java.io.File;
import java.io.IOException;

/**
 * @author user
 */
public class GeneratorCodeUtil {

    //自定义url
    public static final String DB_URL = "jdbc:mysql://localhost:3306/febs_base?characterEncoding=utf-8&useSSL=false";

    /**
     * 请自定义自己的username
     */
    public static final String USERNAME = "root";

    /**
     * 请自定义自己的password
     */
    public static final String PASSWORD = "root";

    public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    /**
     * 请自定义自己的包名，后续的代码生成会在这个包下
     */
    public static final String PACKAGE_NAME = "com.ljh.demo";

    /**
     * 请自定义自己的模块名（可以理解为项目名称）
     */
    public static final String MODULE_NAME = "demo-shiro";

    public static void main(String[] args) throws IOException {
        System.out.println("--------------------开始自动生成相关的类----------------------");
        System.out.println("args = " + new File("").getAbsolutePath() + "/src/main/java/");
        GenerateByTables.generateByTable(MODULE_NAME, "t_dept");
        System.out.println("--------------------------生成成功------------------------");
    }
}

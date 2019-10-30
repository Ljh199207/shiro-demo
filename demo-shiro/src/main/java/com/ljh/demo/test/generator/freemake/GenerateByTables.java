package com.ljh.demo.test.generator.freemake;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.ljh.demo.test.generator.velocity.GeneratorCodeUtil;

import java.io.File;

/**
 * @author ljh
 */
public class GenerateByTables {

    public static void generateByTable(String module, String... tableNames) {
        moduleGenerator(module, tableNames);
    }

    private static void moduleGenerator(String module, String[] tableNames) {
        // 全局配置
        GlobalConfig globalConfig = getGlobalConfig(module);
        // 数据源配置
        DataSourceConfig dataSourceConfig = getDataSourceConfig();
        // 包配置
        PackageConfig packageConfig = getPackageConfig();

        // 策略配置
        StrategyConfig strategyConfig = getStrategyConfig(tableNames);

        // 模板配置
        TemplateConfig templateConfig = getTemplateConfig();

        new AutoGenerator().setGlobalConfig(globalConfig)
                .setDataSource(dataSourceConfig)
                .setPackageInfo(packageConfig)
                .setStrategy(strategyConfig)
                .setTemplate(templateConfig)
                .setTemplateEngine(new FreemarkerTemplateEngine())
                .execute();
    }

    private static TemplateConfig getTemplateConfig() {
        TemplateConfig templateConfig = new TemplateConfig();
        templateConfig.setEntity("generator/entity")
                .setMapper("generator/mapper")
                .setXml("generator/mapperXml")
                .setService("generator/service")
                .setServiceImpl("generator/serviceImpl")
                .setController("generator/controller");
        return templateConfig;

    }

    private static StrategyConfig getStrategyConfig(String[] tableNames) {
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setCapitalMode(true)
                .setEntityLombokModel(true)
                .setEntityColumnConstant(true)
                .setRestControllerStyle(true)
                .setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setInclude(tableNames);
        return strategyConfig;
    }

    private static PackageConfig getPackageConfig() {
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent(GeneratorCodeUtil.PACKAGE_NAME)
                .setController("controller")
                .setEntity("entity")
                .setMapper("mapper")
                .setService("service")
                .setServiceImpl("service.impl");
        return packageConfig;
    }

    private static DataSourceConfig getDataSourceConfig() {
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(GeneratorCodeUtil.DB_URL)
                .setUsername(GeneratorCodeUtil.USERNAME)
                .setPassword(GeneratorCodeUtil.PASSWORD)
                .setDriverName(GeneratorCodeUtil.DRIVER_NAME);
        return dataSourceConfig;
    }

    /**
     * 全局配置，生成目录
     *
     * @param module
     * @return
     */
    private static GlobalConfig getGlobalConfig(String module) {
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOpen(false)
                .setOutputDir(new File(module).getAbsolutePath() + "/src/main/java")
                .setFileOverride(true)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setActiveRecord(true)
                .setAuthor("ljh")
                .setServiceName("%sService");
        return globalConfig;
    }
}

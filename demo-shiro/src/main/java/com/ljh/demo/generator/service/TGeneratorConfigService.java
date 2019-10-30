package com.ljh.demo.generator.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ljh.demo.generator.entity.TGeneratorConfig;

/**
 * <p>
 * 代码生成配置表 服务类
 * </p>
 *
 * @author ljh
 * @since 2019-10-28
 */
public interface TGeneratorConfigService extends IService<TGeneratorConfig> {

    /**
     * 查询
     *
     * @return GeneratorConfig
     */
    TGeneratorConfig findGeneratorConfig();

    /**
     * 修改
     *
     * @param generatorConfig generatorConfig
     */
    void updateGeneratorConfig(TGeneratorConfig generatorConfig);
}

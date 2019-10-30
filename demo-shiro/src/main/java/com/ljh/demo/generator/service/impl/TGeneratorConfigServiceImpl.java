package com.ljh.demo.generator.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljh.demo.generator.entity.TGeneratorConfig;
import com.ljh.demo.generator.mapper.TGeneratorConfigMapper;
import com.ljh.demo.generator.service.TGeneratorConfigService;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 代码生成配置表 服务实现类
 * </p>
 *
 * @author ljh
 * @since 2019-10-28
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class TGeneratorConfigServiceImpl extends ServiceImpl<TGeneratorConfigMapper, TGeneratorConfig> implements TGeneratorConfigService {

    /**
     * 查询
     *
     * @return GeneratorConfig
     */
    @Override
    public TGeneratorConfig findGeneratorConfig() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",2);
        List<TGeneratorConfig> generatorConfigs = this.baseMapper.selectList(queryWrapper);
        return CollectionUtils.isNotEmpty(generatorConfigs) ? generatorConfigs.get(0) : null;
    }

    /**
     * 修改
     *
     * @param generatorConfig generatorConfig
     */
    @Override
    public void updateGeneratorConfig(TGeneratorConfig generatorConfig) {
        this.saveOrUpdate(generatorConfig);
    }
}

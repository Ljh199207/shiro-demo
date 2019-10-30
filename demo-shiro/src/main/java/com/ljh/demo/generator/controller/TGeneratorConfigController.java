package com.ljh.demo.generator.controller;


import com.ljh.demo.generator.entity.TGeneratorConfig;
import com.ljh.demo.common.entity.FebsResponse;
import com.ljh.demo.generator.service.TGeneratorConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 * 代码生成配置表 前端控制器
 * </p>
 *
 * @author ljh
 * @since 2019-10-28
 */
@RestController
@RequestMapping("/generatorConfig")
@Api(tags = "代码生成配置表")
public class TGeneratorConfigController {

    @Autowired
    private TGeneratorConfigService generatorConfigService;

    @GetMapping
    @ApiOperation(value = "获取配置")
    public FebsResponse getGeneratorConfig() {
        return new FebsResponse().success().data(generatorConfigService.findGeneratorConfig());
    }

    @PostMapping("update")
    @ApiOperation(value = "更改配置")
    public FebsResponse updateGeneratorConfig(@Valid TGeneratorConfig generatorConfig) throws Exception {
        if (StringUtils.isBlank(generatorConfig.getId())) {
            throw new Exception("配置id不能为空");
        }
        this.generatorConfigService.updateGeneratorConfig(generatorConfig);
        return new FebsResponse().success();
    }
}

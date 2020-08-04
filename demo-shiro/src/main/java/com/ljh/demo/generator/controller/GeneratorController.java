package com.ljh.demo.generator.controller;

import com.ljh.demo.common.controller.BaseController;
import com.ljh.demo.common.entity.FebsResponse;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.common.exception.FebsException;
import com.ljh.demo.common.utils.FebsUtil;
import com.ljh.demo.common.utils.FileUtil;
import com.ljh.demo.generator.entity.Column;
import com.ljh.demo.generator.entity.GeneratorConfig;
import com.ljh.demo.generator.entity.GeneratorConstant;
import com.ljh.demo.generator.entity.TGeneratorConfig;
import com.ljh.demo.generator.service.IGeneratorService;
import com.ljh.demo.generator.service.TGeneratorConfigService;
import com.ljh.demo.generator.vo.GenerateParam;
import com.ljh.demo.test.generator.helper.GeneratorHelper;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author MrBird
 */
@Slf4j
@RestController
@RequestMapping("generator")
@Api(tags = "代码生成")
public class GeneratorController extends BaseController {

    private static final String SUFFIX = "_code.zip";

    @Autowired
    private IGeneratorService generatorService;
    @Autowired
    private TGeneratorConfigService generatorConfigService;
    @Autowired
    private GeneratorHelper generatorHelper;

    @GetMapping("tables/info")
    public FebsResponse tablesInfo(String tableName, QueryRequest request) {
        Map<String, Object> dataTable = getDataTable(generatorService.getTables(tableName, request, GeneratorConstant.DATABASE_TYPE, GeneratorConstant.DATABASE_NAME));
        return new FebsResponse().success().data(dataTable);
    }

    @PostMapping
    public void generate(@RequestBody List<GenerateParam> generateParams, HttpServletResponse response) throws Exception {
        TGeneratorConfig generatorConfig = generatorConfigService.findGeneratorConfig();
        if (generatorConfig == null) {
            throw new FebsException("代码生成配置为空");
        }
        if (generateParams != null) {
            generateParams.forEach(generateParam -> {
                String className = generateParam.getName();
                if (GeneratorConfig.TRIM_YES.equals(generatorConfig.getIsTrim())) {
                    className = RegExUtils.replaceFirst(generateParam.getName(), generatorConfig.getTrimValue(), StringUtils.EMPTY);
                }
                generatorConfig.setTableName(generateParam.getName());
                generatorConfig.setClassName(FebsUtil.underscoreToCamel(className));
                generatorConfig.setTableComment(generateParam.getRemake());
                // 生成代码到临时目录
                List<Column> columns = generatorService.getColumns(GeneratorConstant.DATABASE_TYPE, GeneratorConstant.DATABASE_NAME, generateParam.getName());
                try {
                    generatorHelper.generateServiceImplFile(columns, generatorConfig);
                    generatorHelper.generateEntityFile(columns, generatorConfig);
                    generatorHelper.generateMapperFile(columns, generatorConfig);
                    generatorHelper.generateMapperXmlFile(columns, generatorConfig);
                    generatorHelper.generateServiceFile(columns, generatorConfig);
                    generatorHelper.generateControllerFile(columns, generatorConfig);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        // 打包
        String zipFile = System.currentTimeMillis() + SUFFIX;
        FileUtil.compress(GeneratorConstant.TEMP_PATH + "src", zipFile);
        // 下载
        FileUtil.download(zipFile, "name" + SUFFIX, true, response);
        // 删除临时目录
        FileUtil.delete(GeneratorConstant.TEMP_PATH);
    }
}

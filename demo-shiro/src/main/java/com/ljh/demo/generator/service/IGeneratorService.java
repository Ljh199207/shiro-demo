package com.ljh.demo.generator.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.generator.entity.Column;
import com.ljh.demo.generator.entity.Table;

import java.util.List;

/**
 * @author MrBird
 */
public interface IGeneratorService {

    List<String> getDatabases(String databaseType);

    IPage<Table> getTables(String tableName, QueryRequest request, String databaseType, String schemaName);

    List<Column> getColumns(String databaseType, String schemaName, String tableName);
}

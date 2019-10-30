package com.ljh.demo.system.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.system.entity.Dept;

import java.util.List;

/**
* 部门表 Service接口
*
* @author ljh
* @date 2019-10-30 14:45:19
*/
public interface IDeptService extends IService<Dept> {
/**
* 查询（分页）
*
* @param request QueryRequest
* @param dept dept
* @return IPage<Dept>
*/
IPage<Dept> findDepts(QueryRequest request, Dept dept);

/**
* 查询（所有）
*
* @param dept dept
* @return List<Dept>
*/
List<Dept> findDepts(Dept dept);

/**
* 新增
*
* @param dept dept
*/
void createDept(Dept dept);

/**
* 修改
*
* @param dept dept
*/
void updateDept(Dept dept);

/**
* 删除
*
* @param dept dept
*/
void deleteDept(Dept dept);
}

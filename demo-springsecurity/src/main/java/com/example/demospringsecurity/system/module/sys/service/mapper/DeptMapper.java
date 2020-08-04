package com.example.demospringsecurity.system.module.sys.service.mapper;

import com.example.demospringsecurity.common.base.BaseMapper;
import com.example.demospringsecurity.system.module.sys.entity.Dept;
import com.example.demospringsecurity.system.module.sys.service.dto.DeptDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2019-03-25
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptMapper extends BaseMapper<DeptDTO, Dept> {

}
package com.example.demospringsecurity.system.module.sys.service.mapper;

import com.example.demospringsecurity.common.base.BaseMapper;
import com.example.demospringsecurity.system.module.sys.entity.Dict;
import com.example.demospringsecurity.system.module.sys.service.dto.DictDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2019-04-10
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DictMapper extends BaseMapper<DictDTO, Dict> {

}
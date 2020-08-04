package com.example.demospringsecurity.system.module.sys.service.mapper;

import com.example.demospringsecurity.common.base.BaseMapper;
import com.example.demospringsecurity.system.module.sys.entity.Job;
import com.example.demospringsecurity.system.module.sys.service.dto.JobSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2019-03-29
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface JobSmallMapper extends BaseMapper<JobSmallDTO, Job> {

}
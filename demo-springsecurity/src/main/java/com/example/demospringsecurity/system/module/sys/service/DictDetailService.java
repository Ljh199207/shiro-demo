package com.example.demospringsecurity.system.module.sys.service;

import com.example.demospringsecurity.system.module.sys.entity.DictDetail;
import com.example.demospringsecurity.system.module.sys.service.dto.DictDetailDTO;
import com.example.demospringsecurity.system.module.sys.service.dto.DictDetailQueryCriteria;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * @author Zheng Jie
 * @date 2019-04-10
 */
public interface DictDetailService {

    DictDetailDTO findById(Long id);

    DictDetailDTO create(DictDetail resources);

    void update(DictDetail resources);

    void delete(Long id);

    Map queryAll(DictDetailQueryCriteria criteria, Pageable pageable);
}
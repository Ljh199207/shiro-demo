package com.example.demospringsecurity.system.module.sys.repository;

import com.example.demospringsecurity.system.module.sys.entity.Dict;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Zheng Jie
 * @date 2019-04-10
 */
public interface DictRepository extends JpaRepository<Dict, Long>, JpaSpecificationExecutor<Dict> {
}
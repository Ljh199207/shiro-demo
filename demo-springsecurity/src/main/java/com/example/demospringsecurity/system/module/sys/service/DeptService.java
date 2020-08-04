package com.example.demospringsecurity.system.module.sys.service;

import com.example.demospringsecurity.system.module.sys.entity.Dept;
import com.example.demospringsecurity.system.module.sys.service.dto.DeptDTO;
import com.example.demospringsecurity.system.module.sys.service.dto.DeptQueryCriteria;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

/**
 * @author Zheng Jie
 * @date 2019-03-25
 */
public interface DeptService {

    List<DeptDTO> queryAll(DeptQueryCriteria criteria);

    DeptDTO findById(Long id);

    DeptDTO create(Dept resources);

    void update(Dept resources);

    void delete(Long id);

    Object buildTree(List<DeptDTO> deptDTOS);

    List<Dept> findByPid(long pid);

    Set<Dept> findByRoleIds(Long id);

    void download(List<DeptDTO> queryAll, HttpServletResponse response) throws IOException;
}
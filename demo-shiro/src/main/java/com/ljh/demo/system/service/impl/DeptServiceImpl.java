package com.ljh.demo.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ljh.demo.common.entity.DeptTree;
import com.ljh.demo.common.entity.QueryRequest;
import com.ljh.demo.common.utils.TreeUtil;
import com.ljh.demo.system.entity.Dept;
import com.ljh.demo.system.mapper.DeptMapper;
import com.ljh.demo.system.service.IDeptService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 部门表 Service实现
 *
 * @author ljh
 * @date 2019-10-30 14:45:19
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements IDeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public IPage<Dept> findDepts(QueryRequest request, Dept dept) {
        LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<>();
// TODO 设置查询条件
        Page<Dept> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<DeptTree<Dept>> findDepts() {
        List<Dept> list = this.baseMapper.selectList(new QueryWrapper<>());
        List<DeptTree<Dept>> trees = this.convertDepts(list);
        return TreeUtil.buildDeptTree(trees);
    }

    @Override
    @Transactional
    public void createDept(Dept dept) {
        this.save(dept);
    }

    @Override
    @Transactional
    public void updateDept(Dept dept) {
        this.saveOrUpdate(dept);
    }

    @Override
    @Transactional
    public void deleteDept(Dept dept) {
        LambdaQueryWrapper<Dept> wrapper = new LambdaQueryWrapper<>();
// TODO 设置删除条件
        this.remove(wrapper);
    }

    @Override
    public List<DeptTree<Dept>> findDeptTree(Dept dept) {
        LambdaQueryWrapper<Dept> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(dept.getDeptName())) {
            queryWrapper.like(Dept::getDeptName, dept.getDeptName());
        }
        queryWrapper.orderByAsc(Dept::getOrderNum);
        List<Dept> list = this.baseMapper.selectList(queryWrapper);
        List<DeptTree<Dept>> trees = this.convertDepts(list);
        return TreeUtil.buildDeptTree(trees);
    }

    private List<DeptTree<Dept>> convertDepts(List<Dept> list) {
        List<DeptTree<Dept>> lists = new ArrayList<>();
        list.forEach(dept -> {
            DeptTree<Dept> deptDeptTree = new DeptTree<>();
            deptDeptTree.setId(String.valueOf(dept.getDeptId()));
            deptDeptTree.setParentId(String.valueOf(dept.getParentId()));
            deptDeptTree.setName(dept.getDeptName());
            deptDeptTree.setData(dept);
            lists.add(deptDeptTree);
        });
        return lists;
    }
}

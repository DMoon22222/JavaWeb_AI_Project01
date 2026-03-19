package com.scut.tliaswebmangement.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scut.tliaswebmangement.mapper.EmpMapper;
import com.scut.tliaswebmangement.pojo.Emp;
import com.scut.tliaswebmangement.pojo.PageResult;
import com.scut.tliaswebmangement.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    /*
     *
     * 原始分页查询
     */
     /*
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1、调用mapper接口，查询总记录数
        Long total = empMapper.count();
        //2、调用mapper接口，查询结果列表
        Integer start=(page-1)*pageSize;
        List<Emp> rows = empMapper.list(start, pageSize);

        //3、封装结果PageResult
        return new PageResult<Emp>(total, rows);

      */
    /*
     * PageHelper分页查询
     * @param page:当前页码
     * @param pageSize:每页显示的记录数
     */
    @Override
    public PageResult<Emp> page(Integer page, Integer pageSize) {
        //1、设置分页参数(PageHelper)
        PageHelper.startPage(page, pageSize);
        //2、查询所有员工
        List<Emp> empList = empMapper.list();
        //3、解析查询结果，并封装
        Page<Emp> p=(Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(),p.getResult());
    }
}

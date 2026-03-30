package com.scut.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scut.mapper.ClazzMapper;
import com.scut.mapper.DeptMapper;
import com.scut.pojo.Clazz;
import com.scut.pojo.PageResult;
import com.scut.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public void add(Clazz clazz) {
        //1.补全基础属性
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());

        clazzMapper.insert(clazz);

    }

    @Override
    public List<Clazz> findAll() {
        return clazzMapper.findAll();
    }

    @Override
    public PageResult<Clazz> page(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Clazz> clazzList = clazzMapper.list(name, begin, end);
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public Clazz getInfo(Integer id) {
        return clazzMapper.getById(id);
    }

    @Override
    public void deleteById(Integer id) {
         clazzMapper.deleteById(id);
    }

    @Override
    public void update(Clazz clazz) {
        clazzMapper.update(clazz);
    }
}

package com.scut.service.impl;


import com.scut.mapper.ClazzMapper;
import com.scut.mapper.DeptMapper;
import com.scut.pojo.Clazz;
import com.scut.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

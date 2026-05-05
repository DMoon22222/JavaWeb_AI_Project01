package com.scut.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scut.mapper.LogMapper;
import com.scut.pojo.OperateLog;
import com.scut.pojo.PageResult;
import com.scut.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    private LogMapper logMapper;

    @Override
    public PageResult<OperateLog> page(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        List<OperateLog> logList=logMapper.list(page,pageSize);
        Page<OperateLog> p=(Page<OperateLog>)logList;
        return new PageResult<>(p.getTotal(),p.getResult());
    }
}

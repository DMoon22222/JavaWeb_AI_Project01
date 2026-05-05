package com.scut.mapper;

import com.scut.pojo.OperateLog;

import java.util.List;

@Mapper
public interface LogMapper {
    List<OperateLog> list(Integer page, Integer pageSize);
}

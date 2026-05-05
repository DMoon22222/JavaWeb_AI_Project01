package com.scut.service;

import com.scut.pojo.OperateLog;
import com.scut.pojo.PageResult;

public interface LogService {
    PageResult<OperateLog> page(Integer page, Integer pageSize);
}

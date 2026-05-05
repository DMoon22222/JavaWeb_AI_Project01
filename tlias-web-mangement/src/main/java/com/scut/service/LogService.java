package com.scut.service;

import com.scut.anno.Log;
import com.scut.pojo.PageResult;

public interface LogService {
    PageResult<Log> page(Integer page, Integer pageSize);
}

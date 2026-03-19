package com.scut.tliaswebmangement.service;

import com.scut.tliaswebmangement.pojo.Emp;
import com.scut.tliaswebmangement.pojo.PageResult;

public interface EmpService {
    /*
       分页查询
       @param page:当前页码
       @param pageSize:每页显示的记录数
       @return:分页查询结果
     */
    PageResult<Emp> page(Integer page, Integer pageSize);
}

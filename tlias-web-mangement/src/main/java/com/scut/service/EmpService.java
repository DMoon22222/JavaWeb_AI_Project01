package com.scut.service;

import com.scut.pojo.Emp;
import com.scut.pojo.EmpQueryParam;
import com.scut.pojo.PageResult;

import java.time.LocalDate;

public interface EmpService {


    /*
       分页查询

     */
    PageResult<Emp> page(EmpQueryParam empQueryParam);
 /*
   添加员工
  */
    void save(Emp emp);
    /*
       分页查询
       @param page:当前页码
       @param pageSize:每页显示的记录数
       @return:分页查询结果
     */
    //PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin,LocalDate end);
}

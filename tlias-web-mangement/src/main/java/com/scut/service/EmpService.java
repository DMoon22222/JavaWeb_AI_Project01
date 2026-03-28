package com.scut.service;

import com.scut.pojo.Emp;
import com.scut.pojo.EmpQueryParam;
import com.scut.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

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
     批量删除员工
     */
    void delete(List<Integer> ids);

    /*
     * 根据ID查询员工信息以及工作经历信息
     */
    Emp getInfo(Integer id);

    /*
     * 修改员工信息
     */
    void update(Emp emp);
    /*
       分页查询
       @param page:当前页码
       @param pageSize:每页显示的记录数
       @return:分页查询结果
     */
    //PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin,LocalDate end);
}

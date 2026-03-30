package com.scut.service;

import com.scut.pojo.Clazz;
import com.scut.pojo.PageResult;

import java.time.LocalDate;
import java.util.List;

public interface ClazzService {
    /*
     * 添加班级信息
     */
    void add(Clazz clazz);

    /*
     * 查询所有班级信息
     */
    List<Clazz> findAll();

    /*
    分页查询
     */
    PageResult<Clazz> page(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    /*
     * 根据ID查询班级信息
     */
    Clazz getInfo(Integer id);

    /*
     * 根据Id删除班级信息
     */
    void deleteById(Integer id);

    /*
     * 修改班级信息
     */
    void update(Clazz clazz);
}

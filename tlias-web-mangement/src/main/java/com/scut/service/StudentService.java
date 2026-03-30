package com.scut.service;

import com.scut.pojo.PageResult;
import com.scut.pojo.Student;

import java.util.List;

public interface StudentService {
    /*
     * 分页查询
     */
    PageResult<Student> page(String name, Integer degree, Integer clazzId, Integer page, Integer pageSize);

    /*
     * 添加学员信息
     */
    void add(Student student);

    /*
     * 根据ID查询学员信息
     */
    Student getInfoById(Integer id);

    /*
     * 根据ID批量删除学员信息
     */
    void deleteByIds(List<Integer> ids);

    /*
     * 修改学员信息
     */
    void update(Student student);

    /*
     * 修改学员的违规次数和违规分数
     */
    void updateViolation(Integer id, Integer score);
}

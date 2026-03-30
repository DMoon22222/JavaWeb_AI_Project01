package com.scut.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.scut.mapper.StudentMapper;
import com.scut.pojo.PageResult;
import com.scut.pojo.Student;
import com.scut.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public PageResult<Student> page(String name, Integer degree, Integer clazzId, Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);
        List<Student> studentList = studentMapper.list(name, degree, clazzId);
        Page<Student> p = (Page<Student>) studentList;
        return new PageResult<>(p.getTotal(), p.getResult());
    }

    @Override
    public void add(Student student) {
        studentMapper.insert(student);
    }

    @Override
    public Student getInfoById(Integer id) {
        return studentMapper.getInfoById(id);
    }

    @Override
    public void deleteByIds(List<Integer> ids) {
        studentMapper.deleteByIds(ids);
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void updateViolation(Integer id, Integer score) {
        studentMapper.updateViolation(id,score);
    }
}

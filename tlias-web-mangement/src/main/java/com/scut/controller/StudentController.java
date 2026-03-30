package com.scut.controller;

import com.github.pagehelper.Page;
import com.scut.pojo.PageResult;
import com.scut.pojo.Result;
import com.scut.pojo.Student;
import com.scut.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    /*
     * 条件分页查询
     */
    @GetMapping
    public Result page(String name,
                       Integer degree,
                       Integer clazzId,
                       @RequestParam Integer page,
                       @RequestParam Integer pageSize)
    {
        log.info("分页查询，参数：{},{},{},{},{}",name,degree,clazzId,page,pageSize);
        PageResult<Student> studentList=studentService.page(name,degree,clazzId,page,pageSize);
        return Result.success(studentList);
    }
    /*
     * 添加学员信息
     */
    @PostMapping
    public Result add(@RequestBody Student student)
    {
        log.info("添加学员信息：{}",student);
        studentService.add(student);
        return Result.success();
    }
    /*
     * 根据ID查询学员信息
     */
    @GetMapping("/{id}")
    public Result getInfoById(@PathVariable Integer id)
    {
        log.info("根据ID查询学员信息：{}",id);
        Student student=studentService.getInfoById(id);
        return Result.success(student);
    }
    /*
     * 删除学员信息
     */
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids)
    {
        log.info("删除学员信息：{}",ids);
        studentService.deleteByIds(ids);
        return Result.success();
    }
    /*
     *  更新学员信息
     */
    @PutMapping
    public Result update(@RequestBody Student student)
    {
        log.info("修改学员信息：{}",student);
        studentService.update(student);
        return Result.success();
    }
    /*
     * 违纪处理
     */
    @PutMapping("/violation/{id}/{score}")
    public Result updateViolation(@PathVariable Integer id,@PathVariable Integer score)
    {
        log.info("违纪处理：{},{}",id,score);
        studentService.updateViolation(id,score);
        return Result.success();
    }

}

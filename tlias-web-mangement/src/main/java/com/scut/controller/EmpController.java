package com.scut.controller;

import com.scut.pojo.Emp;
import com.scut.pojo.EmpQueryParam;
import com.scut.pojo.PageResult;
import com.scut.pojo.Result;
import com.scut.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

/*
 * 员工管理Controller
 */
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;
    /*
     * 分页查询

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam (defaultValue = "10") Integer pageSize,
                       String name, Integer gender,
                       @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate begin,
                       @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate end){
         log.info("分页查询请求参数：{}，{}，{}，{}，{}",page,pageSize,name,gender,begin,end);
         PageResult <Emp> pageResult=empService.page(page,pageSize,name,gender,begin,end);
         return Result.success(pageResult);
    }
    */

    @GetMapping
    public Result page(EmpQueryParam empQueryParam){
        log.info("分页查询请求参数：{}",empQueryParam);
        PageResult <Emp> pageResult=empService.page(empQueryParam);
        return Result.success(pageResult);
    }
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工：{}",emp);
        empService.save(emp);
        return Result.success();
    }

}

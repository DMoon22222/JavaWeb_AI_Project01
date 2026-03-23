package com.scut.controller;

import com.scut.pojo.Clazz;
import com.scut.pojo.Result;
import com.scut.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加班级：{}",clazz);
        clazzService.add(clazz);
        return Result.success();
    }
    @GetMapping("/list")
    public Result list(){
        log.info("查询全部班级数据");
        List<Clazz> clazzList=clazzService.findAll();
        return Result.success(clazzList);
    }

}

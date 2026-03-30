package com.scut.controller;

import com.scut.pojo.Clazz;
import com.scut.pojo.PageResult;
import com.scut.pojo.Result;
import com.scut.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {
    @Autowired
    private ClazzService clazzService;

    /*
     * 添加班级
     */
    @PostMapping
    public Result add(@RequestBody Clazz clazz){
        log.info("添加班级：{}",clazz);
        clazzService.add(clazz);
        return Result.success();
    }
    /*
     * 查询所有班级数据
     */
    @GetMapping("/list")
    public Result list(){
        log.info("查询全部班级数据");
        List<Clazz> clazzList=clazzService.findAll();
        return Result.success(clazzList);
    }
    /*
     * 条件分页查询
     */
    @GetMapping
    public Result page(String name,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern="yyyy-MM-dd")LocalDate end,
                       @RequestParam Integer page,
                       @RequestParam Integer pageSize){
        log.info("分页查询，参数：{},{},{},{},{}",name,begin,end,page,pageSize);
        PageResult<Clazz> pageResult=clazzService.page(name,begin,end,page,pageSize);
        return Result.success(pageResult);
    }
    /*
     * 根据ID查询班级接口
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id)
    {
        log.info("根据ID查询班级接口：{}",id);
        Clazz clazz=clazzService.getInfo(id);
        return Result.success(clazz);
    }
    /*
     * 删除班级信息
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id)
    {
        log.info("删除班级信息：{}",id);
        clazzService.deleteById(id);
        return Result.success();
    }
    /*
     * 修改班级信息
     */
    @PutMapping
    public Result update(@RequestBody Clazz clazz)
    {
        log.info("修改班级信息：{}",clazz);
        clazzService.update(clazz);
        return Result.success();
    }


}

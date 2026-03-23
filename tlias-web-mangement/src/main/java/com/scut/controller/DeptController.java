package com.scut.controller;

import com.scut.pojo.Dept;
import com.scut.pojo.Result;
import com.scut.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    //@RequestMapping(value="/depts",method= RequestMethod.GET)//method:指定请求方式
    /*
    查询部门列表
     */
    @GetMapping
    public Result list(){
        //System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        List<Dept> deptList=deptService.findAll();
        return Result.success(deptList);
    }
    /*
     * 删除部门 方式1：使用HttpServletRequest 获取请求参数

    @DeleteMapping("/depts")
    public Result delete(HttpServletRequest request){
        String idStr = request.getParameter("id");
        int id=Integer.parseInt(idStr);
        System.out.println("根据ID删除部门："+id);
        return Result.success();
    }

     */
     /*
      * 删除部门 方式2：使用@RequestParam 获取请求参数

    @DeleteMapping("/depts")
    public Result delete(@RequestParam(value="id",required = false) Integer deptId){

        System.out.println("根据ID删除部门："+deptId);
        return Result.success();
    }

      */
     /*
      * 方式3：省略@RequestParam注解（前端传递的请求参数名与服务器方法形参名一致）
      */
     @DeleteMapping
     public Result delete(Integer id){

        //System.out.println("根据ID删除部门："+id);
        log.info("根据ID删除部门：{}",id);
        deptService.deleteById(id);
        return Result.success();
    }
    /*
     * 添加部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        //System.out.println("添加部门："+dept);
        log.info("添加部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }
    /*
     * 根据ID查询部门
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable("id") Integer deptId){
        System.out.println("根据ID查询部门："+deptId);
        return Result.success();
    }
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        //System.out.println("根据ID查询部门："+id);
        log.info("根据ID查询部门：{}",id);
        Dept dept=deptService.getById(id);
        return Result.success(dept);
    }
    /*
     * 修改部门
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        //System.out.println("修改部门："+dept);
        log.info("修改部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }


}

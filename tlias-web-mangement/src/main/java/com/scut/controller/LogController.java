package com.scut.controller;


import com.scut.pojo.OperateLog;
import com.scut.pojo.PageResult;
import com.scut.pojo.Result;
import com.scut.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/log")
@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/page")
    public Result page(@RequestParam Integer page,
                       @RequestParam Integer pageSize)
    {
        log.info("分页查询日志信息，参数：{},{}",page,pageSize);
        PageResult<OperateLog> logList=logService.page(page,pageSize);
        return Result.success(logList);
    }


}

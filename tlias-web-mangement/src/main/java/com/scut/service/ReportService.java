package com.scut.service;

import com.scut.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /*
     * 获取员工职位数据
     */
    JobOption getEmpJobData();

    /*
     * 获取员工性别人数
     */
    List<Map<String, Object>> getEmpGenderData();
}

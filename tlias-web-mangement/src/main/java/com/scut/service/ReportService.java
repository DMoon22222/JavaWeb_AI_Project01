package com.scut.service;

import com.scut.pojo.ClazzCountOption;
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

    /*
     * 获取班级人数
     */
    ClazzCountOption getStudentCountData();

    /*
     * 获取学员学历信息
     */
    List<Map> getStudentDegreeData();
}

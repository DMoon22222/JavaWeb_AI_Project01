package com.scut.mapper;

import com.scut.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    /*
     * 分页查询
     */
    List<Student> list(String name, Integer degree, Integer clazzId);

    /*
     * 添加学员信息
     */
    @Insert("insert into student(name,no,gender,phone,degree,clazz_id,id_card,is_college,address,graduation_date) values(#{name},#{no},#{gender},#{phone},#{degree},#{clazzId},#{idCard},#{isCollege},#{address},#{graduationDate})")
    void insert(Student student);

    /*
     * 根据ID查询学员信息
     */
    @Select("select id,name,no,gender,phone,degree,id_card,is_college,address,graduation_date,violation_count,violation_score,clazz_id,create_time,update_time from student where id=#{id}")
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
     * 修改学员违规次数和违规分数
     */
    void updateViolation(Integer id, Integer score);

    /*
     * 查询班级人数
     */
    @Select("select c.name as cname,count(s.id) scount from clazz c left join student s on s.clazz_id=c.id group by c.name order by count(s.id) desc")
    List<Map<String, Object>> countClazzCountData();

    /*
     * 查询学员学历信息
     */
    @MapKey("name")
    List<Map> countStudentDegreeData();
}

package com.scut.mapper;

import com.scut.pojo.Clazz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface ClazzMapper {

    /**
     * 添加班级
     * @param clazz
     */
    @Insert("insert into clazz(name,room,begin_date,end_date,master_id,subject,create_time,update_time) values (#{name},#{room},#{beginDate},#{endDate},#{masterId},#{subject},#{createTime},#{updateTime})")
    void insert(Clazz clazz);

    /**
     * 查询所有班级
     * @return
     */
    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz order by update_time desc;")
    List<Clazz> findAll();

    /**
     * 条件查询
     * @param name
     * @param begin
     * @param end
     * @return
     */

    List<Clazz> list(@Param("name") String name, @Param("begin") LocalDate begin, @Param("end") LocalDate end);

    /**
     * 根据ID查询班级信息
     * @param id
     * @return
     */
    @Select("select id, name, room, begin_date, end_date, master_id, subject, create_time, update_time from clazz where id = #{id}")
    Clazz getById(Integer id);


    /**
     * 根据ID删除班级信息
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 修改班级信息
     * @param clazz
     */
    void update(Clazz clazz);


}

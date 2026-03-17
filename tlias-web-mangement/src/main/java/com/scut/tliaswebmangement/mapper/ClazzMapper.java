package com.scut.tliaswebmangement.mapper;

import com.scut.tliaswebmangement.pojo.Clazz;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

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
}

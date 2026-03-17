package com.scut.tliaswebmangement.service;

import com.scut.tliaswebmangement.pojo.Clazz;

import java.util.List;

public interface ClazzService {
    /*
    添加班级信息
     */
    void add(Clazz clazz);

    List<Clazz> findAll();
}

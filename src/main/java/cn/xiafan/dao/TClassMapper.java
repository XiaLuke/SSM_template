package cn.xiafan.dao;

import cn.xiafan.entity.TClass;

import java.util.List;

public interface TClassMapper {
    List<TClass> list();

    int insert(TClass tClass);
}

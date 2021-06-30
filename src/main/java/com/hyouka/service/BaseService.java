package com.hyouka.service;

import tk.mybatis.mapper.entity.Example;

import java.util.List;

public interface BaseService<T> {
    List<T> select(T t);

    List<T> selectAll();

    int insert(T t);

    int update(T t, Example example);

    int updateById(T t);

    int delete(T t);

    int selectCount(T t);

}

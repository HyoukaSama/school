package com.hyouka.utils;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.special.InsertListMapper;

public interface BaseDao<T> extends Mapper<T>, InsertListMapper {
}

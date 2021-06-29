package com.hyouka.service.impl;

import com.hyouka.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    public void setMapper(Mapper<T> mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<T> select(T t) {
        return mapper.select(t);
    }

    @Override
    public List<T> selectAll() {
        return mapper.selectAll();
    }

    @Override
    public int insert(T t) {
        return mapper.insert(t);
    }

    @Override
    public int update(T t, Example example) {
        return mapper.updateByExampleSelective(t,example);
    }

    @Override
    public int updateById(T t) {
        return mapper.updateByPrimaryKeySelective(t);
    }

    @Override
    public int delete(T t) {
        return mapper.delete(t);
    }
}

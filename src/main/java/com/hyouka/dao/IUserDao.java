package com.hyouka.dao;

import com.hyouka.entity.User;
import com.hyouka.utils.BaseDao;

import java.util.List;


public interface IUserDao extends BaseDao<User> {
    List<User> getAllUser();

    List<User> getUserDuty();
}

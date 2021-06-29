package com.hyouka.service.impl;


import com.hyouka.dao.IUserDao;
import com.hyouka.entity.User;
import com.hyouka.service.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements IUserService {

    @Autowired
    private IUserDao iUserDao;

    @Override
    public List<User> getAllUser() {
        return iUserDao.getAllUser();
    }

}

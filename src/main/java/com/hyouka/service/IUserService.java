package com.hyouka.service;

import com.hyouka.entity.User;

import java.util.List;


public interface IUserService extends BaseService<User> {
    List<User> getAllUser();


}

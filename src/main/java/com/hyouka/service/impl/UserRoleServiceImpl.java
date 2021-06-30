package com.hyouka.service.impl;

import com.hyouka.dao.IUserRoleDao;
import com.hyouka.entity.UserRole;
import com.hyouka.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl extends BaseServiceImpl<UserRole> implements IUserRoleService {
    @Autowired
    private IUserRoleDao iUserRoleDao;

    @Override
    public int insertUserRole(UserRole userRole) {
        return iUserRoleDao.insertUserRole(userRole);
    }
}

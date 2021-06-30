package com.hyouka.dao;

import com.hyouka.entity.UserRole;
import com.hyouka.utils.BaseDao;

public interface IUserRoleDao extends BaseDao<UserRole> {

    public int insertUserRole(UserRole userRole);
}

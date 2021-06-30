package com.hyouka.service;

import com.hyouka.entity.UserRole;

public interface IUserRoleService extends BaseService<UserRole> {
    public int insertUserRole(UserRole userRole);
}

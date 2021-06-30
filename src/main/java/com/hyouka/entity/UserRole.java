package com.hyouka.entity;

import net.sf.json.JSONObject;

import javax.persistence.Table;

@Table(name = "UserRole")
public class UserRole {
    String userid;
    String roleid;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}

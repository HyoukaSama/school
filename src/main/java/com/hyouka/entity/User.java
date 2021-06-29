package com.hyouka.entity;


import com.hyouka.utils.UUIDGenId;
import net.sf.json.JSONObject;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.*;

@Table(name = "user")
public class User {
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "account")
    private String account;

    @Column(name = "password")
    private String passwd;

    @Column(name = "createtime")
    private String createtime;

    public User() {
    }

    public User( String name, Integer age, String sex, String account, String passwd, String createtime) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.account = account;
        this.passwd = passwd;
        this.createtime = createtime;
    }



    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}

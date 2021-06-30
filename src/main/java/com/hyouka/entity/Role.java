package com.hyouka.entity;

import com.hyouka.utils.UUIDGenId;
import net.sf.json.JSONObject;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "role")
public class Role {
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    private String name;

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

    @Override
    public String toString() {
        return JSONObject.fromObject(this).toString();
    }
}

package com.hyouka.service.impl;

import com.hyouka.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;

public class JedisCluster implements JedisClient {
    @Autowired
    private JedisCluster jedisCluster;

    public JedisCluster getJedisCluster() {
        return jedisCluster;
    }

    public void setJedisCluster(JedisCluster jedisCluster) {
        this.jedisCluster = jedisCluster;
    }

    @Override
    public String get(String key) {
        return jedisCluster.get(key);
    }

    @Override
    public String set(String key, String value) {
        return jedisCluster.set(key, value);
    }

    @Override
    public String hget(String hkey, String key) {
        return jedisCluster.hget(hkey, key);
    }

    @Override
    public long hset(String hkey, String key, String value) {
        return jedisCluster.hset(hkey, key, value);
    }

    @Override
    public long incr(String key) {
        return jedisCluster.incr(key);
    }

    @Override
    public long expire(String key, int seconds) {
        return jedisCluster.expire(key, seconds);
    }

    @Override
    public long ttl(String key) {
        return jedisCluster.ttl(key);
    }

    @Override
    public long del(String key) {
        return jedisCluster.del(key);
    }

    @Override
    public long hdel(String hkey, String key) {
        return jedisCluster.hdel(hkey, key);
    }
}

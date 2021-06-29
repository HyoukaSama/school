package com.hyouka.service.impl;

import com.hyouka.dao.JedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class JedisClientPool implements JedisClient {
    @Autowired
    private JedisPool jedisPool;

    private Jedis jedis;

    @Override
    public String get(String key) {
        jedis = jedisPool.getResource();
        String string = jedis.get(key);
        jedis.close();
        return string;
    }

    @Override
    public String set(String key, String value) {
        jedis = jedisPool.getResource();
        String string = jedis.set(key, value);
        jedis.close();
        return string;
    }

    @Override
    public String hget(String hkey, String key) {
        jedis = jedisPool.getResource();
        String string = jedis.hget(hkey, key);
        jedis.close();
        return string;
    }

    @Override
    public long hset(String hkey, String key, String value) {
        jedis = jedisPool.getResource();
        long string = jedis.hset(hkey, key, value);
        jedis.close();
        return string;
    }

    @Override
    public long incr(String key) {
        jedis = jedisPool.getResource();
        long result = jedis.incr(key);
        jedis.close();
        return result;
    }

    @Override
    public long expire(String key, int seconds) {
        jedis = jedisPool.getResource();
        long result = jedis.expire(key, seconds);
        jedis.close();
        return result;
    }

    @Override
    public long ttl(String key) {
        jedis = jedisPool.getResource();
        long result = jedis.ttl(key);
        jedis.close();
        return result;
    }

    @Override
    public long del(String key) {
        jedis = jedisPool.getResource();
        long result = jedis.del(key);
        jedis.close();
        return result;
    }

    @Override
    public long hdel(String hkey, String key) {
        jedis = jedisPool.getResource();
        long result = jedis.hdel(hkey, key);
        jedis.close();
        return result;
    }
}

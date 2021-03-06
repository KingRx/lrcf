package com.lrcf.yhb.common.redis;

/**
 * Redis统一接口
 * Created by Krx on 2017/6/15 0015.
 */
public interface JedisClient {

    String get(String key);

    String set(String key, String value);

    String hget(String hkey, String key);

    long hset(String hkey, String key, String value);

    long incr(String key);

    long expire(String key, Integer second);

    long ttl(String key);

    long del(String key);

    long hdel(String hkey, String key);

}

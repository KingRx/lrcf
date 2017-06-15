package com.lrcf.yhb.service;

import com.lrcf.yhb.api.AccountsUsersService;
import com.lrcf.yhb.common.redis.JedisClient;
import com.lrcf.yhb.common.redis.RedisUtil;
import com.lrcf.yhb.dao.mapper.AccountsUsersMapper;
import com.lrcf.yhb.pojo.AccountsUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by Administrator on 2017/6/13.
 */
@Service("accountsUsersService")
public class AccountsUsersServiceImpl implements AccountsUsersService {


    @Autowired
    AccountsUsersMapper accountsUsersMapper;

    @Value("${redisKey.prefix.user_session}")
    private String USER_SESSION;

    @Value("${redisKey.expire_time}")
    private Integer EXPIRE_TIME;

    @Override
    public AccountsUsers getUserInfoByPhone(String phone) {
        return accountsUsersMapper.selectByPrimaryKey(phone);
    }

    @Override
    public AccountsUsers getUserByUserId(String userId) {
        String token = UUID.randomUUID().toString().replaceAll("-","");

        String key = USER_SESSION + token;
        RedisUtil.set(key,USER_SESSION);
        RedisUtil.expire(key, EXPIRE_TIME);
        return accountsUsersMapper.selectByPrimaryKey(userId);
    }

}

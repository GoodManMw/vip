package com.goodmanm.vip.dao;

import org.springframework.stereotype.Repository;

import com.goodmanm.vip.entity.UserEntity;

@Repository
public interface UserDao {
	public UserEntity selectByAccount(String account)throws Exception;
}

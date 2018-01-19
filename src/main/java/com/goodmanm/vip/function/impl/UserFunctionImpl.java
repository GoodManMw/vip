package com.goodmanm.vip.function.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodmanm.vip.dao.UserDao;
import com.goodmanm.vip.entity.UserEntity;
import com.goodmanm.vip.function.UserFunction;

@Service("UserFunction")
public class UserFunctionImpl implements UserFunction{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public UserEntity login(String account, String password) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		return null;
	}
	
}

package com.goodmanm.vip.function;

import org.springframework.transaction.annotation.Transactional;

import com.goodmanm.common.ThisSystemException;
import com.goodmanm.vip.entity.UserEntity;

public interface UserFunction {
	
	/*
	 * 用户登录
	 * @param account
	 * @param password
	 * @return 
	 * @throws Exception
	 * */
	public UserEntity login(String account, String password)throws ThisSystemException;
	
	@Transactional
	public UserEntity updatePassword(String id, String oldPassword, String newPassword, String newPasswordConfirm)throws ThisSystemException;
	
}

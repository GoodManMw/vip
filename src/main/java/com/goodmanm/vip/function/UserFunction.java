package com.goodmanm.vip.function;

import com.goodmanm.vip.entity.UserEntity;

public interface UserFunction {
	public UserEntity login(String account, String password)throws Exception;
}

package com.goodmanm.vip.function.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goodmanm.common.ThisSystemException;
import com.goodmanm.common.AssertThrowUtil;
import com.goodmanm.vip.dao.UserDao;
import com.goodmanm.vip.entity.UserEntity;
import com.goodmanm.vip.function.UserFunction;

@Service("UserFunction")
public class UserFunctionImpl implements UserFunction{
	
	@Autowired
	UserDao userDao;
	
	@Override
	public UserEntity login(String account, String password) throws ThisSystemException {
		// TODO Auto-generated method stub
		
		account = AssertThrowUtil.assertNotBlank("账户不能为空", account);
		password = AssertThrowUtil.assertNotBlank("密码不能为空", password);
		
		UserEntity u = userDao.select("account", account);
		if(u == null){
			throw new ThisSystemException("账号不存在!");
		}
		if(!u.getPassword().equals(password)){
			throw new ThisSystemException("密码错误!");
		}
		
		return u;
	}
	
	@Override
	public UserEntity updatePassword(String id, String oldPassword, String newPassword, String newPasswordConfirm)
			throws ThisSystemException {
		// TODO Auto-generated method stub
		
		//1.验证参数
		id = AssertThrowUtil.assertNotBlank("id不能为空", id);
		oldPassword = AssertThrowUtil.assertNotBlank("旧密码必须填写", oldPassword);
		newPassword = AssertThrowUtil.assertNotBlank("新密码必须填写", newPassword);
		newPasswordConfirm = AssertThrowUtil.assertNotBlank("新密码确认必须填写", newPasswordConfirm);
		AssertThrowUtil.assertEquals("两次密码不一致", newPassword, newPasswordConfirm);
		AssertThrowUtil.assertNotEquals("新密码和旧密码不能一样", oldPassword, newPassword);
		
		//2.找到用户
		UserEntity u = userDao.select("id", id);
		AssertThrowUtil.assertNotNull("无法找到用户", u);
		
		//3.验证机旧密码
		AssertThrowUtil.assertEquals("旧密码不正确", u.getPassword(), oldPassword);
		
		//4.更新新密码
		u.setPassword(newPassword);
		userDao.update(u);
		
		return u;
	}
	
}

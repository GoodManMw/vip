package com.goodmanm.vip.function.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.goodmanm.common.AssertThrowUtil;
import com.goodmanm.common.ThisSystemException;
import com.goodmanm.common.ThisSystemUtil;
import com.goodmanm.vip.dao.VIPDao;
import com.goodmanm.vip.entity.VIPEntity;
import com.goodmanm.vip.function.VIPFunction;
import com.goodmanm.vip.web.handler.argumentobject.VIPAo;

@Service("VIPFunction")
public class VIPFunctionImpl implements VIPFunction{

	@Autowired
	private VIPDao vipDao;
	
	@Override
	public VIPEntity queryVIP(String code) throws ThisSystemException {
		// TODO Auto-generated method stub
		//1.验证参数
		code = AssertThrowUtil.assertNotBlank("vip账号必须填写", code);
		//2.业务处理
		VIPEntity v = vipDao.select("code", code);
		AssertThrowUtil.assertNotNull("未找到此VIP客户[" + code +"]", v);
		//3.封装业务结果
		return v;
	}
	
	@Override
	@Transactional
	public VIPEntity addVIP(VIPAo ao) throws ThisSystemException {
		// TODO Auto-generated method stub
		//1 参数验证
		if(ao == null){
			throw new IllegalArgumentException("ao不能为空");
		}
		//1.1 验证是否必须输入字段
		String phone = AssertThrowUtil.assertNotBlank("手机号码必须填写", ao.getPhone());
		String name = AssertThrowUtil.assertNotBlank("手机号码必须填写", ao.getName());
		//1.2 验证手机号是否合法
		AssertThrowUtil.assertPatternMatch("手机号码不合法", "\\d{11}",phone);
		//1.3 验证手机号码是否已存在
		AssertThrowUtil.assertFalse("手机号码已存在", vipDao.exists("code", phone));
		//1.4 验证名字是否合法
		AssertThrowUtil.assertPatternMatch("姓名不合法", "[\u4e00-\u9fa5]{2,}", name);
		//1.5 判断性别
		boolean male = "1".equals(ao.getSex());
		//1.6 获取年龄
		int age = ThisSystemUtil.parseInt(ao.getAge(), 0);
		//2 业务处理
		VIPEntity  v = new VIPEntity();
		
		v.setId(ThisSystemUtil.uuid());
		v.setAddress(ao.getAddress());
		v.setAge(age);
		v.setAmount(0);
		v.setCode(phone);
		v.setEmail(ao.getEmail());
		v.setSex(male);
		v.setName(name);
		v.setQq(ao.getQq());
		v.setRank(0);
		v.setRemark(ao.getRemark());
		v.setZip(ao.getZip());
		vipDao.insert(v);
		//3 封装业务结果
		return v;
	}
	
}

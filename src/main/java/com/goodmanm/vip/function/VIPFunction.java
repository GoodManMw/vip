package com.goodmanm.vip.function;

import com.goodmanm.common.ThisSystemException;
import com.goodmanm.vip.entity.VIPEntity;
import com.goodmanm.vip.web.handler.argumentobject.VIPAo;

public interface VIPFunction {
	/*
	 * vip客户查询
	 * @param code
	 * @return 
	 * @throws Exception
	 * */
	public VIPEntity queryVIP(String code)throws ThisSystemException;
	/*
	 * 录入vip
	 * @param ao
	 * @return 
	 * @throws Exception
	 * */
	public VIPEntity addVIP(VIPAo ao)throws ThisSystemException;
}

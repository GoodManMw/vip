package com.goodmanm.common;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AbstractDao<T> {
	/*
	 * 增改操作
	 * */
	void insert(T t)throws ThisSystemException;
	void update(T t)throws ThisSystemException;
	
	/*
	 * 删除操作
	 * */
	void delete(@Param("key")String uqfileld, @Param("value")Object value)throws ThisSystemException;
	
	/*
	 * 查询操作
	 * */
	T select(@Param("key")String uqfiled, @Param("value")Object value)throws ThisSystemException;
	boolean exists(@Param("key")String uqfiled, @Param("value")Object value)throws ThisSystemException;
	List<T> selectLike(@Param("key")String key)throws ThisSystemException;
	
}

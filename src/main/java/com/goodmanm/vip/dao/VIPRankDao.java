package com.goodmanm.vip.dao;

import java.util.List;

import com.goodmanm.vip.entity.VIPRankEntity;

public interface VIPRankDao {
	public List<VIPRankEntity> selectAll()throws Exception;
}

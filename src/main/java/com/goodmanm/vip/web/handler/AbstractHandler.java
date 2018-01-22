package com.goodmanm.vip.web.handler;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.goodmanm.vip.entity.VIPRankEntity;

public abstract class AbstractHandler {

	public VIPRankEntity getRank(HttpServletRequest req, int rank){
		Map<Integer, VIPRankEntity> ranksMap = (Map<Integer, VIPRankEntity>)req.getServletContext().getAttribute("RANKS-MAP");
		return ranksMap.get(rank);
	}
	
}

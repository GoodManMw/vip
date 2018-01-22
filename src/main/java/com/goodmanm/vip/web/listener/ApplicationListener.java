package com.goodmanm.vip.web.listener;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.goodmanm.vip.dao.VIPRankDao;
import com.goodmanm.vip.entity.VIPRankEntity;

public class ApplicationListener extends ContextLoaderListener  implements ServletContextListener{
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		super.contextDestroyed(arg0);
	}
	
	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		super.contextInitialized(arg0);
		ServletContext sc = arg0.getServletContext();
		//初始化系统数据
		try{
			this.initVipRank(sc);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void initVipRank(ServletContext sc)throws Exception{
		
		WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(sc);
		VIPRankDao rdao = ac.getBean(VIPRankDao.class);
		//获取Dao
		List<VIPRankEntity> ranks = rdao.selectAll();
		Map<Integer, VIPRankEntity> ranksMap = new HashMap<>();
		for(VIPRankEntity r : ranks){
			ranksMap.put(r.getCode(), r);
		}
		sc.setAttribute("RANKS-MAP", ranksMap);
		
	}
	
}

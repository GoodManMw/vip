package com.goodmanm.vip.web.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goodmanm.common.ThisSystemException;
import com.goodmanm.vip.entity.VIPEntity;
import com.goodmanm.vip.entity.VIPRankEntity;
import com.goodmanm.vip.function.VIPFunction;
import com.goodmanm.vip.web.handler.argumentobject.VIPAo;
import com.goodmanm.vip.web.handler.viewobject.VIPVo;

@Controller
public class VIPHandler extends AbstractHandler{
	
	@Autowired
	VIPFunction fun;

	@RequestMapping(path = "vip/qry.do", method = RequestMethod.GET)
	public String qryView()throws Exception{
		return "vip/qry";
	}
	
	@RequestMapping(path = "vip/qry.do", method = RequestMethod.POST)
	public String qry(String code, HttpServletRequest req)throws ThisSystemException{
		
		try{
			VIPEntity v = fun.queryVIP(code);
			VIPVo vo = new VIPVo();
			vo.setAddress(v.getAddress());
			vo.setAge(String.valueOf(v.getAge()));
			vo.setAmount(String.valueOf(v.getAmount() / 100.0));
			vo.setCode(v.getCode());
			vo.setEmail(v.getEmail());
			vo.setName(v.getName());
			System.out.println("VIP Guest' Name :" + vo.getName());
			vo.setQq(v.getQq());
			int RankInt = v.getRank();
			VIPRankEntity rank = this.getRank(req, v.getRank());
			//TODO:查询vip级别
			vo.setRank(rank.getName());
			System.out.println("rank :" + rank.getName());
			vo.setRemark(v.getRemark());
			vo.setSex(v.isSex() ? "男" : "女");
			vo.setZip(v.getZip());
			req.setAttribute("v", vo);
		}catch(ThisSystemException e){
			req.setAttribute("message", e.getMessage());
		}
		
		return "vip/qry";
	}
	
	@RequestMapping(path = "vip/add.do", method = RequestMethod.GET)
	public String addView(){
		return "vip/add";
	}
	
	@RequestMapping(path = "vip/add.do", method = RequestMethod.POST)
	public String addVip(VIPAo ao, HttpServletRequest req){
		try{
			//1 业务方法执行
			VIPEntity v = fun.addVIP(ao);
			//2 业务跳转
			//TODO:后期跳转到消费录入页面
			req.setAttribute("message", "录入成功");
			return "vip/add";
		}catch(ThisSystemException e){
			req.setAttribute("message", e.getMessage());
		}

		return "vip/add";
	}
	
}

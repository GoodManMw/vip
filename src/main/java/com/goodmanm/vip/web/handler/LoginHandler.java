package com.goodmanm.vip.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goodmanm.vip.entity.UserEntity;
import com.goodmanm.vip.function.UserFunction;

@Controller
public class LoginHandler {

	@Autowired
	UserFunction fun;
	
	@RequestMapping("/login.do")
	public String login(String account, String password, HttpServletRequest request){
		
		try {
			UserEntity u = fun.login(account, password);
			HttpSession session = request.getSession();
			session.setAttribute("currentUser", u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			request.setAttribute("message", e.getMessage());
			return "farword:/login.jsp";
		}
		return "redirect:/index.do";
	}
	
	@RequestMapping("/index.do")
	public String index(){
		return "index";
	}
	
}

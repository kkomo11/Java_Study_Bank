package com.iu.start.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.bankmembers.BankMembersDTO;

public class MemberInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
//		BankMembersDTO bankMembersDTO = request.getSession().getAttribute("member");
		Object obj = request.getSession().getAttribute("member");
		if(obj != null) {
			System.out.println("로그인 함");
			return true;
		} else {
			System.out.println("로그인 안함");
			response.sendRedirect("../member/login.iu");
			return false;
		}
	}
}
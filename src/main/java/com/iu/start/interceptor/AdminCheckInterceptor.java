package com.iu.start.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.bankmembers.BankMembersDTO;
import com.iu.start.bankmembers.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean check = false;
		BankMembersDTO bankMembersDTO = (BankMembersDTO) request.getSession().getAttribute("member");
		for(RoleDTO roleDTO : bankMembersDTO.getRoleDTOs()) {
			if(roleDTO.getRoleName().equals("admin")) {
				check = true;
			}
		}
		
		if(!check) {
			request.setAttribute("message", "권한이 없습니다.");
			request.setAttribute("url", "../../../../../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}
		return check;
	}
}
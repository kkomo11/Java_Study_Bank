package com.iu.start.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.bankmembers.BankMembersDTO;
import com.iu.start.board.impl.BoardDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter {
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
		String method = request.getMethod();
		if(method.equals("POST")) {
			return ;
		}
		BankMembersDTO bankMembersDTO = (BankMembersDTO) request.getSession().getAttribute("member");
		Map<String, Object> map = modelAndView.getModel();
		System.out.println(map);
		BoardDTO boardDTO = (BoardDTO) map.get("dto");
		if(!bankMembersDTO.getUserName().equals(boardDTO.getWriter())) {
			modelAndView.setViewName("common/result");
			modelAndView.addObject("message", "작성자만 수정 가능");
			modelAndView.addObject("url", "list.iu");
		}
	}
}
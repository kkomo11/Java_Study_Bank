package com.iu.start.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class BackErrorController {

	// exception Handler만 모아놓기
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exceptionTest(Exception e) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("errors/error_404");
		
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("errors/error_404");
		
		return mv;
	}
}
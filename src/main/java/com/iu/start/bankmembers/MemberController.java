package com.iu.start.bankmembers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
@RequestMapping(value = "/member/*")
// 이 클래스는 Controller 역할,
// Container에게 이 클래스의 객체를 생성을 위임.
public class MemberController {
	
	BankMembersDAO bankMembersDAO = new BankMembersDAO();
	// annotation
	// @ : 설명 + 실행
	
	// /member/login
	@RequestMapping(value = "login")
	public String login() {
		System.out.println("Login 실행");
		
		return "member/login";
	}
	
	// /member/join GET
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("join GET 실행");
		
		return "member/join";
	}
	
	// /member/join POST
	// 절대경로로 작성
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("join POST 실행");
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		if(result == 0) {
			System.out.println("실패");
		} else {
			System.out.println("성공");
		}
		
		return "member/join";
	}
}
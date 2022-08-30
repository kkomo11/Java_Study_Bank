package com.iu.start.bankaccount;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iu.start.bankmembers.BankMembersDTO;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@GetMapping("add.iu")
	public String setAccount(BankAccountDTO bankAccountDTO, HttpSession session) throws Exception {
		// 보안때문에 id를 파라미터로 넘기지 않고 Session으로 받는다.
		bankAccountDTO.setUserName(((BankMembersDTO) session.getAttribute("member")).getUserName());
		int result = accountService.setAccount(bankAccountDTO);
		
		return "redirect:../book/list.iu";
	}
}
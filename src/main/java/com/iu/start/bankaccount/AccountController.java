package com.iu.start.bankaccount;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.bankmembers.BankMembersDTO;

@Controller
@RequestMapping(value = "/account/*")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAccount(BankAccountDTO bankAccountDTO, HttpSession session) throws Exception {
		// 보안때문에 id를 파라미터로 넘기지 않고 Session으로 받는다.
		bankAccountDTO.setId(((BankMembersDTO) session.getAttribute("member")).getId());
		int result = accountService.setAccount(bankAccountDTO);
		System.out.println(result==1);
		
		return "redirect:../book/list.iu";
	}
}
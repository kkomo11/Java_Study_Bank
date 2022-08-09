package com.iu.start.bankbook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/book/*")
public class BookController {
	
	BankBookDAO bankBookDAO = new BankBookDAO();
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(HttpServletRequest request) throws Exception {
		System.out.println("리스트 실행");
		
		ArrayList<BankBookDTO> arr = bankBookDAO.getList();
		request.setAttribute("list", arr);
		return "book/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Long bookNum, HttpServletRequest request) throws Exception {
		System.out.println("디테일 실행");
		System.out.println(bookNum);
		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBookNum(Long.parseLong(request.getParameter("bookNum")));
		bankBookDTO.setBookNum(bookNum);
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		request.setAttribute("detail", bankBookDTO);
		return "book/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		
		System.out.println("add Form 실행");
		
		return "book/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(BankBookDTO bankBookDTO) throws Exception {
		
		System.out.println("add Post 실행");
		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result == 1);
	}
}
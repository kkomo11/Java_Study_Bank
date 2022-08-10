package com.iu.start.bankbook;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/book/*")
public class BookController {
	
	BankBookDAO bankBookDAO = new BankBookDAO();
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		System.out.println("리스트 실행");
		
		ArrayList<BankBookDTO> arr = bankBookDAO.getList();
		model.addAttribute("list", arr);
		return "book/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("디테일 실행");
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		mv.addObject("detail", bankBookDTO);
		mv.setViewName("book/detail");
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
		
		System.out.println("add Form 실행");
		
		//return "book/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		
		System.out.println("add Post 실행");
		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result == 1);
		mv.setViewName("redirect:list");
		return mv;
	}
}
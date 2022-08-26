package com.iu.start.bankbook;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/book/*")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		System.out.println("리스트 실행");
		
		model.addAttribute("list", bookService.getList());
		return "book/list";
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bookService.getDetail(bankBookDTO);
		mv.addObject("detail", bankBookDTO);
		mv.setViewName("book/detail");
		return mv;
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void add() {
		
		System.out.println("add Form 실행");
		
		//return "book/add";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		
		Calendar ca = Calendar.getInstance();	
		bankBookDTO.setBookNum(ca.getTimeInMillis());
		int result = bookService.setBankBook(bankBookDTO);
		mv.setViewName("redirect:list.iu");
		return mv;
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public ModelAndView update(BankBookDTO dto, ModelAndView mv) throws Exception {
		dto = bookService.getDetail(dto);
		mv.addObject("detail", dto);
		mv.setViewName("book/update");
		return mv;
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public ModelAndView update(BankBookDTO dto) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = bookService.setUpdate(dto);
//		mv.setViewName("redirect:detail?bookNum="+dto.getBookNum());
		mv.setViewName("redirect:list.iu");
		return mv;
	}
	
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO dto) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = bookService.setDelete(dto);
		mv.setViewName("redirect:list.iu");
		return mv;
	}
}
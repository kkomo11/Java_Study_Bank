package com.iu.start.bankbook;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.util.CommentPager;

@Controller
@RequestMapping("/book/*")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("list.iu")
	public String list(Model model) throws Exception {
		
		model.addAttribute("list", bookService.getList());
		return "book/list";
	}
	
	@GetMapping("detail.iu")
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		bankBookDTO = bookService.getDetail(bankBookDTO);
		mv.addObject("detail", bankBookDTO);
		mv.setViewName("book/detail");
		return mv;
	}
	
	@GetMapping("add.iu")
	public void add() {
		
	}
	
	@PostMapping("add.iu")
	public ModelAndView add(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		
		int result = bookService.setBankBook(bankBookDTO);
		mv.setViewName("redirect:list.iu");
		return mv;
	}
	
	@GetMapping("update.iu")
	public ModelAndView update(BankBookDTO dto, ModelAndView mv) throws Exception {
		dto = bookService.getDetail(dto);
		mv.addObject("detail", dto);
		mv.setViewName("book/update");
		return mv;
	}
	
	@PostMapping("update.iu")
	public ModelAndView update(BankBookDTO dto) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = bookService.setUpdate(dto);
		mv.setViewName("redirect:list.iu");
		return mv;
	}
	
	@GetMapping("delete.iu")
	public ModelAndView delete(BankBookDTO dto) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = bookService.setDelete(dto);
		mv.setViewName("redirect:list.iu");
		return mv;
	}
	
//	@PostMapping("commentAdd")
//	public ModelAndView setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		int result = bookService.setCommentAdd(bankBookCommentDTO);
//		mv.addObject("result", result);
//		mv.setViewName("common/ajaxResult");
//		
//		return mv;
//	}
	
	@PostMapping("commentAdd")
	@ResponseBody
	public String setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		int result = bookService.setCommentAdd(bankBookCommentDTO);
		
		String jsonResult = "{\"result\":\""+result+"\"}";
		return jsonResult;
	}
	
//	@GetMapping("commentList")
//	public ModelAndView getCommentList(CommentPager commentPager) throws Exception {
//		ModelAndView mv = new ModelAndView();
//		List<BankBookCommentDTO> list = bookService.getCommentList(commentPager);
//		
//		mv.addObject("commentList", list);
//		mv.setViewName("common/commentList");
//		
//		return mv;
//	}
	
	@GetMapping("commentList")
	@ResponseBody
	public Map<String, Object> getCommentList(CommentPager commentPager) throws Exception {
		
		List<BankBookCommentDTO> list = bookService.getCommentList(commentPager);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("pager", commentPager);
		
		return map;
	}
	
	@PostMapping("commentDelete")
	@ResponseBody
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return bookService.setCommentDelete(bankBookCommentDTO);
	}
	
	@PostMapping("commentUpdate")
	@ResponseBody
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		return bookService.setCommentUpdate(bankBookCommentDTO);
	}
}
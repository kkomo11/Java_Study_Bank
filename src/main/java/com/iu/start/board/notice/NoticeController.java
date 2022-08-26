package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}
	
	// 글 목록
	@GetMapping("list.iu")
	public String getList(Model model, Pager pager) throws Exception {
		List<BoardDTO> list = noticeService.getList(pager);
		
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	// 글 상세
	@GetMapping("detail.iu")
	public ModelAndView getDetail(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("detail", boardDTO);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	// 글 작성
	@GetMapping("add.iu")
	public String setAdd(Model model) throws Exception {
		return "board/add";
	}
	
	@PostMapping("add.iu")
	public String setAdd(BoardDTO boardDTO, Model model) throws Exception {
		int result = noticeService.setAdd(boardDTO);
		
		return "redirect:list.iu";
	}
	
	// 글 수정
	@GetMapping("update.iu")
	public String setUpdate(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("dto", boardDTO);
		
		return "board/update";
	}
	
	@PostMapping("update.iu")
	public String setUpdate(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setUpdate(boardDTO);
		
		return "redirect:detail.iu?num="+boardDTO.getNum();
	}	
	
	// 글 삭제
	@GetMapping("delete.iu")
	public String setDelete(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setDelete(boardDTO);
		
		return "redirect:list.iu";
	}
}

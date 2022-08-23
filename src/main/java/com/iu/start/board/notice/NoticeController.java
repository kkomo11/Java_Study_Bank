package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;

@Controller
@RequestMapping(value = "/notice/*")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	// 글 목록
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		List<BoardDTO> list = noticeService.getList();
		model.addAttribute("list", list);
	}
	
	// 글 상세
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public void getDetail(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		boardDTO = noticeService.getDetail(boardDTO);
		mv.addObject("dto", boardDTO);
		mv.setViewName("notice/detail");
	}
	
	// 글 작성
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void setAdd() throws Exception {
		
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO, Model model) throws Exception {
		int result = noticeService.setAdd(boardDTO);
		
		return "redirect:list.iu";
	}
	
	// 글 수정
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public void setUpdate(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("dto", boardDTO);
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setUpdate(boardDTO);
		
		return "redirect:detail.iu?num="+boardDTO.getNum();
	}	
	
	// 글 삭제
	public String setDelete(BoardDTO boardDTO) throws Exception {
		int result = noticeService.setDelete(boardDTO);
		
		return "redirect:list.iu";
	}
}
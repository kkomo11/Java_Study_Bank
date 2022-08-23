package com.iu.start.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.start.board.impl.BoardDTO;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public void getList(Model model) throws Exception {
		
		List<BoardDTO> list = qnaService.getList();
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public void getDetail(BoardDTO boardDTO, Model model) throws Exception {
		
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("detail", boardDTO);
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void setAdd() throws Exception {
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO) throws Exception {
		int result = qnaService.setAdd(boardDTO);
		
		return "redirect:list.iu";
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public void setUpdate(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("dto", boardDTO);
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception {
		int result = qnaService.setUpdate(boardDTO);
		
		return "redirect:detail.iu?num="+boardDTO.getNum();
	}
	
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception {
		int result = qnaService.setDelete(boardDTO);
		
		return "redirect:list.iu";
	}
}
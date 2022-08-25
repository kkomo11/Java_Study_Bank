package com.iu.start.board.qna;

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
@RequestMapping("/qna/*")
public class QnaController {
	
	@Autowired
	private QnaService qnaService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "QnA";
	}
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public String getList(Model model, Pager pager) throws Exception {
		
		List<BoardDTO> list = qnaService.getList(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception {
		
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("detail", boardDTO);
		
		return "board/detail";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAdd(Model model) throws Exception {
		return "board/add";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public String setAdd(BoardDTO boardDTO) throws Exception {
		int result = qnaService.setAdd(boardDTO);
		
		return "redirect:list.iu";
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public String setUpdate(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("dto", boardDTO);
		
		return "board/update";
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
	
	@GetMapping("reply.iu")
	public ModelAndView setReply(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/reply");
		
		return mv;
	}
	
	@PostMapping("reply.iu")
	public String setReply(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.setReply(qnaDTO);
		return "redirect:list.iu";
	}
}
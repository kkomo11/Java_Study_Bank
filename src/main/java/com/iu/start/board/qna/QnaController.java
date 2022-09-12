package com.iu.start.board.qna;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
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
	
	@GetMapping("list.iu")
	public String getList(Model model, Pager pager) throws Exception {
		
		List<BoardDTO> list = qnaService.getList(pager);
		model.addAttribute("list", list);
		model.addAttribute("pager", pager);
		
		return "board/list";
	}
	
	@GetMapping("detail.iu")
	public String getDetail(BoardDTO dto, Model model) throws Exception {
		
		dto = qnaService.getDetail(dto);
		model.addAttribute("detail", dto);
		
		return "board/detail";
	}
	
	@GetMapping("add.iu")
	public String setAdd(Model model) throws Exception {
		return "board/add";
	}
	
	@PostMapping("add.iu")
	public String setAdd(BoardDTO boardDTO, MultipartFile[] files, HttpSession session) throws Exception {
		int result = qnaService.setAdd(boardDTO, files, session.getServletContext());
		
		return "redirect:list.iu";
	}
	
	@GetMapping("update.iu")
	public String setUpdate(BoardDTO boardDTO, Model model) throws Exception {
		boardDTO = qnaService.getDetail(boardDTO);
		model.addAttribute("dto", boardDTO);
		
		return "board/update";
	}
	
	@PostMapping("update.iu")
	public String setUpdate(BoardDTO boardDTO) throws Exception {
		int result = qnaService.setUpdate(boardDTO);
		
		return "redirect:detail.iu?num="+boardDTO.getNum();
	}
	
	@GetMapping("delete.iu")
	public String setDelete(BoardDTO boardDTO) throws Exception {
		int result = qnaService.setDelete(boardDTO);
		
		return "redirect:list.iu";
	}
	
	@GetMapping("reply.iu")
	public ModelAndView setReply(BoardDTO boardDTO, ModelAndView mv) throws Exception {
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
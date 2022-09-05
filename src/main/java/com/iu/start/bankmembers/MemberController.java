package com.iu.start.bankmembers;


import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller 
@RequestMapping("/member/*")
// 이 클래스는 Controller 역할,
// Container에게 이 클래스의 객체를 생성을 위임.
public class MemberController {
	
	@Autowired
	private MembersService membersService;

	@GetMapping("login.iu")
	public String login() {
		return "member/login";
	}
	
	@PostMapping("login.iu")
	public ModelAndView login(BankMembersDTO bankMembersDTO, Model model, HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		bankMembersDTO = membersService.getLogin(bankMembersDTO);
		session.setAttribute("member", bankMembersDTO);
		
		int result = 0;
		String message = "로그인 실패";
		String url = "login.iu";
		if(bankMembersDTO != null) {
			message = "로그인 성공";
			result = 1;
			url = "../";
		}
		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", url);
		mv.setViewName("common/result");
		return mv;
	}
	
	@GetMapping("terms.iu")
	public String getTerms() {
		return "member/terms";
	}
	
	@GetMapping("join.iu")
	public String join() {
		
		return "member/join";
	}
	
	@PostMapping("join.iu")
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo) throws Exception {
		int result = membersService.setJoin(bankMembersDTO, photo);
		
		return "redirect:login.iu";
	}
	
	@GetMapping("search.iu")
	public ModelAndView getSearchById(ModelAndView mv) {
		mv.setViewName("member/search");
		
		return mv;
	}
	
	@PostMapping("search.iu")
	public ModelAndView getSearchById(ModelAndView mv, String search) throws Exception {
		
		List<BankMembersDTO> list = membersService.getSearchByID(search);
		mv.setViewName("member/list");
		mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping("logout.iu")
	public String logout(HttpSession session) throws Exception {
		// 대개 세션을 소멸시킴
		
		session.invalidate();
		return "redirect:../";
	}
	
	@GetMapping("myPage.iu")
	public void myPage(HttpSession session, Model model) throws Exception {
		BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
		bankMembersDTO = membersService.myPage(bankMembersDTO);
		
		model.addAttribute("dto", bankMembersDTO);
	}
}
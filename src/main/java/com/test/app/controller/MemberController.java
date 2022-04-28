package com.test.app.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.test.app.buyInfo.BuyInfoService;
import com.test.app.buyInfo.BuyInfoVO;
import com.test.app.member.MemberService;
import com.test.app.member.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	@Autowired
	private BuyInfoService buyInfoService;
	
	@ResponseBody
	@RequestMapping(value = "/idCheck.do", method = RequestMethod.POST/*
																		 * , produces =
																		 * "application/json; charset=utf-8"
																		 */ )
	public String Member_checkId(@RequestParam("mid") String id, MemberVO vo) {
		System.out.println("컨토르로러 로그"+id);
		vo.setMid(id);
		System.out.println("컨토르로러 로그"+vo.getMid());
		vo = memberService.Member_checkId(vo);
		
		System.out.println("컨토르로러 로그"+vo);
		if(vo.getMid().equals("가능")) {
			System.out.println("가능");
			return "apple";
		}else {
			
			return "중복";
		}
		
//		mav.addObject("flag", flag+"");
		
	}
	
	@RequestMapping(value = "/signup.do")
	public String Member_insert(MemberVO vo) {
		memberService.Member_insert(vo);
		return "redirect:login.jsp";
	}
	@RequestMapping(value = "/loginpage.do")
	public String Member_selectOne() {
		
			return "redirect:login.jsp";
		
	}
	@RequestMapping(value = "/login.do")
	public String Member_selectOne(MemberVO vo, HttpSession session, Model model) {
		
		vo = memberService.Member_selectOne(vo);
		System.out.println("로그인" + vo);
		
		if(vo==null){
			model.addAttribute("fail", "아이디 또는 비밀번호를 확인해주세요");
			return "login.jsp";
		}
		session.setAttribute("member", vo);
		return "redirect:main.do";
	}
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:main.do";
	}

	@RequestMapping(value = "/mypage.do") // 안할듯? ㄴㄴ 함
	public String Member_mypage(MemberVO vo, BuyInfoVO bvo, HttpSession session, Model model) {
		session.getAttribute("member");
		System.out.println("마이페이지 로그" +vo.getMid());
		System.out.println("마이페이지 로그" +vo.getMpw());
		vo = memberService.Member_selectOne(vo);
		model.addAttribute("mvo", vo);
		bvo.setMid(vo.getMid());
		System.out.println("마이페이지 로그 bvo" +bvo.getMid());
		
		List<BuyInfoVO> datas = buyInfoService.BuyInfo_selectAll_v2(bvo);
		if(datas.size()==0) {
			System.out.println("오류1");
			model.addAttribute("buyNo", "이 없습니다.");
			
		}else {
			System.out.println("오류2");


			model.addAttribute("buyInfoList_buyInfo", datas);

		}
		System.out.println("마이페이지 오류3 로그" +vo);
		return "mypage.jsp";
	}
	@RequestMapping(value = "/updateMember.do")
	public String Member_update(MemberVO vo, HttpSession session) {
		memberService.Member_update(vo);
		session.invalidate();
		return "redirect:main.do";
	}
	@RequestMapping(value = "/deleteMember.do")
	public String Member_delete(MemberVO vo) {
		memberService.Member_delete(vo);
		return "redirect:login.jsp";
	}
	@RequestMapping(value = "/idSearch.do")
	public String Member_idSearch(MemberVO vo, Model model) {
		vo = memberService.Member_idSearch(vo);
		model.addAttribute("memberId", vo);
		return "login.jsp";
	}
	@RequestMapping(value = "/pwSearch.do")
	public String Member_pwSearch(MemberVO vo, Model model) {
		vo = memberService.Member_pwSearch(vo);
		model.addAttribute("memberPw", vo);
		return "login.jsp";
	}

}

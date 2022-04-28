package com.test.app.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.test.app.board.BoardService;
import com.test.app.board.BoardVO;
import com.test.app.buyInfo.BuyInfoService;
import com.test.app.buyInfo.BuyInfoVO;
import com.test.app.member.MemberVO;
import com.test.app.product.ProductService;
import com.test.app.product.ProductVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	@Autowired
	private ProductService productService;
	@Autowired
	private BuyInfoService buyInfoService;

	@RequestMapping(value = "/insertBoard.do")
	public String Board_insert(BoardVO vo) {
		boardService.Board_insert(vo);
		return "redirect:main.do";
	}

	@RequestMapping(value = "/board.do")
	public String Board_selectOne(BoardVO vo, ProductVO pvo, Model model) {
		vo=boardService.Board_selectOne(vo);
		pvo.setPnum(vo.getPnum());
		pvo=productService.Product_selectOne(pvo);
		System.out.println("컨트롤러 보드 로그"+vo);
		System.out.println("컨트롤러 보드 로그"+pvo.getPnum());
		System.out.println("컨트롤러 보드 로그"+pvo);
		model.addAttribute("board", vo);
		model.addAttribute("pvo", pvo);
		return "board.jsp";
	}

	@RequestMapping(value = "/boardList.do")
	public String Board_selectAll(@ModelAttribute("bvo")BoardVO vo, ProductVO pvo, Model model) {
		List<BoardVO> datas = boardService.Board_selectAll(vo);
		if(datas.size()==0) {
			vo.setNoData("가 없습니다");
		}
		model.addAttribute("boardList_Board", datas);
//		System.out.println("컨트롤러 보드리스트 로그"+ datas);
		return "boardList.jsp";
	}

	@RequestMapping(value = "/deleteBoard.do")
	public String Board_delete(BoardVO vo) {
		boardService.Board_delete(vo);
		return "redirect:boardList.do";
	}
	@RequestMapping(value = "/writeBoard.do") // 리뷰페이지 들어가기
	public String Board_write(BoardVO vo, BuyInfoVO bvo, MemberVO mvo, HttpSession session, Model model) {
		mvo = (MemberVO) session.getAttribute("member");
		bvo.setMid(mvo.getMid());

		List<BuyInfoVO> datas = buyInfoService.BuyInfo_selectAll_v2(bvo);

		if(datas.size()==0) {
			return "boardList.do";
		}else {


			model.addAttribute("buyInfo", datas);
			return "boardwrite.jsp";
		}

	}
	@RequestMapping(value = "/boardwrite.do") // 리뷰작성하기
	public String Boardwrite(BoardVO vo, BuyInfoVO bvo, MemberVO mvo,HttpSession session) throws IllegalStateException, IOException {
		// 파일 업로드 로직
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			// 로직수행
			String name = uploadFile.getOriginalFilename();
			System.out.println("파일명 : " + name);
			uploadFile.transferTo(new File("C:\\MOON_Spring\\workspace\\project\\src\\main\\webapp\\images\\"+name));
			vo.setBimg(name);
		} else {
			vo.setBimg("default.png");
		}





		System.out.println(bvo);
		System.out.println("컨트롤러 로그" + bvo.getPnum());
//		mvo = (MemberVO) session.getAttribute("member");
//		bvo.setMid(mvo.getMid());
		boardService.Board_insert(vo);



//		bvo.setPnum(bvo.getPnum());

		bvo.setMid(mvo.getMid());

		buyInfoService.BuyInfo_delete(bvo);


		return "redirect:boardList.do";
	}



	// 검색
	@RequestMapping(value = "")
	public ModelAndView Board_search(BoardVO vo, ModelAndView mav) {
		boardService.Board_search(vo);
		return mav;
	}

}

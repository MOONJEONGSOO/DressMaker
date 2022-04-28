package com.test.app.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.test.app.buyInfo.BuyInfoService;
import com.test.app.buyInfo.BuyInfoVO;
import com.test.app.member.MemberVO;
import com.test.app.product.ProductService;
import com.test.app.product.ProductVO;
import com.test.app.product.impl.SendMail;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private BuyInfoService buyInfoService;

	//	ArrayList<ProductVO> cart = (ArrayList<ProductVO>)session.getAttribute("cart");
	//	if( cart == null ) {
	//		cart = new ArrayList<ProductVO>();
	//		session.setAttribute("cart", cart);
	//	cart.add(vo);	    	
	//	}

	@RequestMapping(value = "/searchProduct.do")
	public String Product_search(@RequestParam(value="page",defaultValue="1",required=false)int page, @ModelAttribute("pvo") ProductVO vo, Model model) {

		//String search=(String)session.getAttribute("search");
		
		System.out.println("가격 검색 로그 컨트롤러 43번 : "+vo.getPstring());

		if(vo.getPstring()!=null) {
			String str=vo.getPstring();
			String a=str.substring(0,str.indexOf("-"));
			String b=str.substring(str.indexOf("-")+1);
			System.out.println(a+"|"+b);
			vo.setPprice(Integer.parseInt(a));
			vo.setPmax(Integer.parseInt(b));
		} else if (vo.getPstring()==null) {
			vo.setPprice(0);
			vo.setPmax(999999);
		}
		System.out.println(vo.getPprice());
		System.out.println(vo.getPmax());

		int i = productService.Product_search_cnt(vo);
		model.addAttribute("productSearch_product_cnt", i);
		//추가해봄
		vo.setPage(page);

		List<ProductVO> datas = productService.Product_search_page(vo, page);
		if(datas.size()==0) {
			vo.setPfail("가 없습니다");
		}
		System.out.println("로그"+datas.size());

		model.addAttribute("searchProduct_product", datas);
		return "productSearch.jsp";
	}



	@RequestMapping(value = "/productList.do")
	public String Product_selectAll(@RequestParam(value="page",defaultValue="1",required=false)int page, ProductVO vo, Model model) {

		int i = productService.Product_selectAll_cnt(vo);
		model.addAttribute("productList_product_cnt", i);

		List<ProductVO> datas = productService.Product_selectAll_page(vo, page);
		model.addAttribute("productList_product", datas);
		return "/productList.jsp";
	}

	@RequestMapping(value = "/main.do")
	public String Main(ProductVO vo, Model model) {
		List<ProductVO> datas = productService.Product_selectAll(vo);
		model.addAttribute("main_product", datas);
		return "main.jsp";
	}


	@RequestMapping(value = "/insertProduct.do")
	public String Product_insert(ProductVO vo) {
		productService.Product_insert(vo);
		return "redirect:상품게시판.do";
	}

	@RequestMapping(value = "/product.do")
	public String Product_selectOne(ProductVO vo, Model model) {
		vo=productService.Product_selectOne(vo);
//		System.out.println("선택"+vo);
		model.addAttribute("product", vo);
		List<ProductVO> datas = productService.Product_selectAll(vo);
		model.addAttribute("productList_product", datas);
		return "product.jsp";
	}

	@RequestMapping(value = "/updateProduct.do") // 구매
	public String Product_update(ProductVO pvo, BuyInfoVO bvo, MemberVO mvo, HttpSession session) {
		// 세션에서 for로 pnum mid 가져오기
		ArrayList<ProductVO> cart = (ArrayList<ProductVO>)session.getAttribute("cart");
		mvo = (MemberVO) session.getAttribute("member");
		System.out.println(mvo.getMmail());


		int cnt = 0; // 로그를 위한 카운트 변수
		while(true) {
			int i = 0;
			bvo.setPnum(cart.get(i).getPnum());
			bvo.setMid(mvo.getMid());

			// 대여중으로 업데이트
			pvo.setPnum(cart.get(i).getPnum());
			pvo.setPrental(cart.get(i).getPrental());
			System.out.println(pvo);
			productService.Product_update(pvo);

			// 구매정보 입력
			buyInfoService.BuyInfo_insert(bvo);

			// 장바구니 비우기
			cart.remove(i);
			cnt++;
			System.out.println("로그 : "+cnt+"번째 구매");
			if(cart.size()==0) {
				break;
			}
			continue;
		}

//		for(int i=0;i<cart.size();i++) {
//
//			System.out.println("로그2");
//			bvo.setPnum(cart.get(i).getPnum());
//			bvo.setMid(mvo.getMid());
//
//			
//			// 대여중으로 업데이트
//			System.out.println("로그4");
//			pvo.setPnum(cart.get(i).getPnum());
//			pvo.setPrental(cart.get(i).getPrental());
//			System.out.println(pvo);
//			productdao.Product_update(pvo);
//
//			
//			// 구매정보 입력
//			System.out.println("로그3");
//			bdao.BuyInfo_insert(bvo);
//
//
//			// 장바구니 비우기
//			System.out.println("로그5");
//			cart.remove(i);
//			System.out.println(i+"번째 구매");
//			continue;
//		}
		SendMail sendmail = new SendMail();
		sendmail.sendmail(mvo.getMmail());

		return "redirect:main.do";
	}
	@RequestMapping(value = "/deleteProduct.do")
	public String Product_delete(ProductVO vo) {
		productService.Product_delete(vo);
		return "redirect:상품게시판.do";
	}
	//	ArrayList<ProductVO> cart =null;
	@RequestMapping(value = "/addCart.do") // 장바구니 담기
	public String Product_selectOne(ProductVO vo, HttpSession session, Model model) {
		vo=productService.Product_selectOne(vo);

		ArrayList<ProductVO> cart = (ArrayList<ProductVO>)session.getAttribute("cart");
		if( cart == null ) {
			cart = new ArrayList<ProductVO>();
			session.setAttribute("cart", cart);
		}

		System.out.println("상품컨트롤러 190 로그" + vo.getPnum());

		if(vo.getPrental().equals("대여가능")) {
			// 중복검사 하자
			for(int i=0;i<cart.size();i++) {
				if(cart.get(i).getPnum()==vo.getPnum()){
					model.addAttribute("addfail", "이미 장바구니에 담은 상품입니다.");
					System.out.println("이미 장바구니에 담은 상품입니다.");
					return "/product.do";
				}

			}

			System.out.println("대여가능하여 장바구니에 담았습니다.");
			cart.add(vo);	    	


			System.out.println("장바구니");
			for (ProductVO v : cart) {
				System.out.println(v);
			}

			System.out.println("카트"+cart);
			return "/shoping-cart.do";
		}else {
			
			model.addAttribute("cfail", "대여중이라 장바구니에 담을 수 없습니다.");
			System.out.println("대여중입니다.");
			return "/product.do";
		}
	}

	@RequestMapping(value = "/shoping-cart.do")
	public String Shoping_cart(HttpSession session, Model model) {
		ArrayList<ProductVO> cart = (ArrayList<ProductVO>)session.getAttribute("cart");
		if( cart == null ) {
			cart = new ArrayList<ProductVO>();
			session.setAttribute("cart", cart);
		}
		if(cart.size()==0) {
			model.addAttribute("noCart", "장바구니에 담긴 상품이 없습니다.");			
		}
		return "shoping-cart.jsp";
	}



	@RequestMapping(value = "/minusCart.do")
	public String Minus_cart(ProductVO vo, HttpSession session, Model model) {
		ArrayList<ProductVO> cart = (ArrayList<ProductVO>)session.getAttribute("cart");
		vo=productService.Product_selectOne(vo);

		if(cart!=null) {
			try {
				for(int i=0;i<cart.size();i++) {
					if(cart.get(i).getPnum()==vo.getPnum()){

						cart.remove(i);
					}

				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}






//		System.out.println("---------"+vo);
//
//		session.removeAttribute("user_id");
		System.out.println("카트"+cart);

		model.addAttribute("cart", cart);
//		productdao.Product_delete(vo);
		return "/shoping-cart.do";
	}
}

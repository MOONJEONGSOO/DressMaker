package controller;

import java.io.IOException;
import org.springframework.stereotype.Service;

import com.test.app.product.ProductVO;
import com.test.app.product.impl.ProductDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlingController2 {

	public void Crawling(ArrayList<ProductVO> datas) {

		// Jsoup를 이용해서 웨딩드레스 크롤링
		String url = "http://www.may-blossom.com/product/list.html?cate_no=42";// 크롤링할 url
		Document doc = null;        

		try {
			doc = Jsoup.connect(url).get();	//Document에는 페이지의 전체 소스가 저장된다
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		//select를 이용하여 원하는 태그를 선택한다.
		Elements element = doc.select("li.xans-record-"); // 드레스 리스트가 있는 태그

		Iterator<Element> itr1 = element.select("div div a span").iterator(); // 제목
		Iterator<Element> itr2 = element.select("div div p span.price").iterator(); // 가격
		Iterator<Element> itr3 = element.select("div div p.info").iterator(); // 정보
		Iterator<Element> itr4 = element.select("div div a img").iterator(); // 썸네일

		while(itr1.hasNext()) {
			ProductVO vo = new ProductVO();
			String pname = itr1.next().text();
//			System.out.println("제목 : "+pname);
			String price=itr2.next().text();
			itr2.next().text();
			price=price.substring(0,price.length()-1);
			price=price.replace(",", "");
			int pprice=Integer.parseInt(price);
//			System.out.println("가격 : "+pprice); // 가격 + 공백
			String pinfo = itr3.next().text();
//			System.out.println("정보 : "+pinfo);
			String pimg = itr4.next().attr("src");
//			System.out.println("썸네일 : "+pimg+"\n");

			vo.setPname(pname);
			vo.setPprice(pprice);
			vo.setPinfo(pinfo);
			vo.setPimg(pimg);

			datas.add(vo);
		}

//				for (Element element1 : element) {
//					System.out.println("제목 : " + element1.select("div div a span").text());	//제목 크롤링
//					System.out.println("가격 : " + element1.select("div div p span.price").text());	//제목 크롤링
//					System.out.println("정보 : " + element1.select("div div p.info").text());	//제목 크롤링
//					System.out.println("썸네일 : " + element1.select("div div a img").attr("src") + "\n" );	//썸네일 크롤링
//				}


		ProductDAO pdao = new ProductDAO();
//		ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
//		CrawlingController2 crawling = new CrawlingController2();
//		crawling.Crawling(datas);

//		for (ProductVO v : datas) {
//			System.out.println(v);
//		}
		for(int i =0; i<datas.size();i++) {
			pdao.Product_insert(datas.get(i));
		}
		System.out.println("크롤링 성공");

	}

//	public static void main(String[] args) {
//		ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
//		CrawlingController2 crawlingController2 = new CrawlingController2();
//		crawlingController2.Crawling(datas);
//		
//		for (ProductVO v : datas) {
//			System.out.println(v);
//		}
//		
//		System.out.println(datas.get(0));
//
//	}
}
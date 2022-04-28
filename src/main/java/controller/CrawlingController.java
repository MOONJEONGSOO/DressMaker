package controller;

import java.io.IOException;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Iterator;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class CrawlingController {

	public static void main(String[] args) {
		// Jsoup를 이용해서 뮤직비디오 크롤링
		String name = "아이유";  //검색할 Artist
		String url = "https://www.genie.co.kr/search/searchMv?query=" + name;//크롤링할 url
		Document doc = null;        


		try {

			doc = Jsoup.connect(url).get();	//Document에는 페이지의 전체 소스가 저장된다

		} 
		catch (IOException e) {

			e.printStackTrace();

		}

		//select를 이용하여 원하는 태그를 선택한다.

		Elements element = doc.select("tr.list");		// MV 리스트가 있는 태그
		String defaulturl = "https://www.genie.co.kr/detail/mediaInfo?xvnm=";

		for (Element element1 : element) {
			System.out.println("제목 : " + element1.select("td a").attr("title") );	//제목 크롤링
			System.out.println("url : " + defaulturl + element1.attr("mvid") );		//url id 크롤링
			System.out.println("썸네일 : " + element1.select("td a img").attr("src") + "\n" );	//썸네일 크롤링
		}


	}

}
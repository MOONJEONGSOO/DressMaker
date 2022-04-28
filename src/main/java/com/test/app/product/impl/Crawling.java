package com.test.app.product.impl;

import java.util.ArrayList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.test.app.product.ProductVO;

import controller.CrawlingController2;

/**
 * Application Lifecycle Listener implementation class Crawling
 *
 */
public class Crawling implements ServletContextListener {

	/**
	 * Default constructor. 
	 */
	public Crawling() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce)  { 
		// TODO Auto-generated method stub
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce)  { 
		// TODO Auto-generated method stub
		// 크롤링 하자
		ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
		CrawlingController2 crawling = new CrawlingController2();
		crawling.Crawling(datas);
		
		
		System.out.println("로그: 서블릿컨테이너(톰캣)의 시작을 감지");
	}


}

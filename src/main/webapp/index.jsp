<%@page import="controller.CrawlingController2"%>
<%@page import="com.test.app.product.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
   // [ 표지페이지의 존재이유 ]
   // main.jsp를 보고싶다!
   // 목록데이터 등을 필요로하기때문에, M(DB)를 가져오기위한 C를 거칠수밖에없다!!!
   // 표지페이지 index.jsp는 C로 이동하여 목록데이터 등을 가져올수있도록 요청하는 역할!!!!!
   
   
	/* ArrayList<ProductVO> datas = new ArrayList<ProductVO>();
	CrawlingController2 crawling = new CrawlingController2();
	crawling.Crawling(datas); */

	response.sendRedirect("main.do");


%>
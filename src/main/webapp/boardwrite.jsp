<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="moon" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="Ogani Template">
    <meta name="keywords" content="Ogani, unica, creative, html">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>DressMaker</title>

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

    <!-- Css Styles -->
    <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
    <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
    <link rel="stylesheet" href="css/nice-select.css" type="text/css">
    <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
    <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
    <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
    <link rel="stylesheet" href="css/style.css" type="text/css">
	<link rel="shortcut icon" href="img/wedding-dress.png">
</head>

<body>
    <!-- Page Preloder -->
    <div id="preloder">
        <div class="loader"></div>
    </div>

    <!-- Humberger Begin -->
   <div class="humberger__menu__overlay"></div>
    <div class="humberger__menu__wrapper">
        <div class="humberger__menu__logo">
            <!-- <a href="#"><img src="img/logo.png" alt=""></a> -->
            <a href="#"><h2>DressMaker</h2></a>
        </div>
        <div class="humberger__menu__cart">
            <ul>
                <!-- <li><a href="#"><i class="fa fa-heart"></i> <span>1</span></a></li> -->
                <li><a href="./shoping-cart.do"><i class="fa fa-shopping-bag"></i> <span>${sessionScope.cart.size()}</span></a></li>
            </ul>
        </div>
        <div class="humberger__menu__widget">
            
        </div>
        <nav class="humberger__menu__nav mobile-menu">
            <ul>
	            <li><a href="./main.do">Home</a></li>
	            <li><a href="./productList.do">dress</a>
	                <ul class="header__menu__dropdown">
	                    <li><a href="./productList.do">셀프웨딩드레스</a></li>
	                    <li><a href="./ready.jsp">하우스드레스</a></li>
	                    <li><a href="./ready.jsp">들러리드레스</a></li>
	                    <li><a href="./ready.jsp">웨딩볼레로</a></li>
	                </ul>
	            </li>
	            <li><a href="./shoping-cart.do">Cart</a></li>
	            <li class="active"><a href="./boardList.do">Review</a></li>
	            <li><a href="./contact.jsp">Contact</a></li>
	            <li><a href="./login.jsp">login</a></li>
	        </ul>
        </nav>
        <div id="mobile-menu-wrap"></div>
        
        <div class="humberger__menu__contact">
            <ul>
                <li><i class="fa fa-envelope"></i>j38317_study@naver.com</li>
                <li>대량 문의는 메일로 부탁드립니다</li>
            </ul>
        </div>
    </div>
    <!-- Humberger End -->

    <!-- Header Section Begin -->
     <header class="header">
    
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="header__logo">
                        <a href="./main.do"><h2>DressMaker</h2></a>
                    </div>
                </div>
                <div class="col-lg-6">
                    <nav class="header__menu">
                        <ul>
                            <li><a href="./main.do"><spring:message code="message.main.home"/></a></li>
                            <li><a href="./productList.do"><spring:message code="message.main.dress"/></a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="./productList.do">셀프웨딩드레스</a></li>
                                    <li><a href="./ready.jsp">하우스드레스</a></li>
                                    <li><a href="./ready.jsp">들러리드레스</a></li>
                                    <li><a href="./ready.jsp">웨딩볼레로</a></li>
                                </ul>
                            </li>
                            <li><a href="./shoping-cart.do"><spring:message code="message.main.cart"/></a></li>
                            <li class="active"><a href="./boardList.do"><spring:message code="message.main.review"/></a></li>
                            <!-- <li><a href="./contact.jsp">Contact</a></li> -->
	                        <!-- 추가 -->
	                        <li>
		                        <div class="header__top__right__language">
					                <!-- <img src="img/language.png" alt=""> -->
					                <div><spring:message code="message.main.language"/></div>
					                <span class="arrow_carrot-down"></span>
					                <ul class="header__menu__dropdown">
					                    <li><a href="main.do?lang=ko">한국어</a></li>
					                    <li><a href="main.do?lang=en">English</a></li>
					                </ul>
					            </div>
	                        </li>
	                        <!-- 추가 -->
                        </ul>
                        
                        
                        
                        
                    </nav>
                </div>
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <li><a href="./shoping-cart.do"><i class="fa fa-shopping-bag"></i><span>${sessionScope.cart.size()}</span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="humberger__open">
                <i class="fa fa-bars"></i>
            </div>
        </div>
    </header>
    <!-- Header Section End -->

    <!-- Hero Section Begin -->
    <section class="hero hero-normal">
        <div class="container">
            <div class="row">
                <div class="col-lg-3">
                    <div class="hero__categories">
                        <div class="hero__categories__all">
                            <i class="fa fa-bars"></i>
                            <span>All departments</span>
                        </div>
                        <ul>
                            
                            <li><a href="./productList.do">셀프웨딩드레스</a></li>
                            <li><a href="./ready.jsp">하우스드레스</a></li>
                            <li><a href="./ready.jsp">들러리드레스</a></li>
                            <li><a href="./ready.jsp">웨딩볼레로</a></li>
                           
                            
                        </ul>
                    </div>
                </div>
                <div class="col-lg-9">
                    <div class="hero__search">
                        <div class="hero__search__form">
                       
                            <form action="./searchProduct.do" method="post">
                                <div class="hero__search__categories">
                                    DRESS
                                    <span class="arrow_carrot-down"></span>
                                </div>
                                <input type="text" name="psearch" placeholder="What do yo u need?">
                                <!-- <input type="hidden" name="pprice" value="0">
                                <input type="hidden" name="pmax" value="9999999"> -->
                                <button type="submit" class="site-btn">SEARCH</button>
                            </form>
                       
                        	
                        </div>
                        <div class="login">
                            <ul>
                            	<moon:login></moon:login>
                            </ul>
                        </div>
                       
                    </div>
                    
                </div>
            </div>
        </div>
    </section>
    <!-- Hero Section End -->

    <!-- Blog Details Hero Begin -->
    <section class="blog-details-hero set-bg" data-setbg="img/productList1.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>ReviewWrite</h2>
                        <div class="breadcrumb__option">
                            <a href="./main.do">Home</a>
                            <span>Review</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Details Hero End -->

    <!-- Blog Section Begin -->
    <section class="blog spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-5">
                    <div class="blog__sidebar">
                        <div class="blog__sidebar__search">
                            <form action="#">
                                <input type="text" placeholder="Search...">
                                <button type="submit"><span class="icon_search"></span></button>
                            </form>
                        </div>
                        <div class="blog__sidebar__item">
                            <h4>Dress</h4>
                            <ul>
                                <li><a href="./productList.do">셀프웨딩드레스</a></li>
	                            <li><a href="./ready.jsp">하우스드레스</a></li>
	                            <li><a href="./ready.jsp">들러리드레스</a></li>
	                            <li><a href="./ready.jsp">웨딩볼레로</a></li>
                            </ul>
                        </div>
                        
                       
                    </div>
                </div>
                <div class="col-lg-8 col-md-7 order-md-1 order-1">
					<div class="section-title product__discount__title">
						<h2>리뷰작성</h2>
					</div>
                    <div class="blog__details__text">
						<form method="post" action="boardwrite.do" enctype="multipart/form-data">
							<table width="700" border="3" bordercolor="lightgray" align="center">
								<tr>
									<td id="title">작성자</td>
									<td><input type="text" name="mid" value="${member.mid}" readonly="readonly"></td>
									<td id="title">상품</td>
									<td>
										<select name="pnum">
											<c:forEach var="bi" items="${buyInfo}">
												<option value="${bi.pnum}">${bi.pname}</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td id="title">
										제 목
									</td>
									<td colspan="3">
										<input name="btitle" type="text" size="70" maxlength="100"  placeholder="Enter your subject"/>
									</td>        
								</tr>
								<tr>
									<td id="title">
										내 용
									</td>
									<td colspan="3">
										<textarea name="bcontent" cols="72" rows="20" placeholder="Enter your message"></textarea>            
									</td>        
								</tr>
								<tr>
									<td id="title">
										파일첨부
									</td>
									<td>
										<input type="file" name="uploadFile" />
									</td>    
								</tr>
								    
							</table>
							<br>
							<div class="login">
								<ul class="actions" style="float: right;">
									<li><input type="submit" value="작성하기" class="primary" style="background: #f9e7dde6; color: #6E6E6E;"/></li>
									<li><input type="reset" value="다시작성" style="background: #f9e7dde6; color: #6E6E6E;"/></li>
									<li><input type="button" value="리뷰 목록보기" onclick="location.href='./boardList.do'" style="background: #f9e7dde6; color: #6E6E6E;"></li>
								</ul>  
							</div>
						</form>
                    </div>
                    <div class="blog__details__content">
                        <div class="row">
                            <div class="col-lg-6">
                                <!-- <div class="blog__details__author">
                                    <div class="blog__details__author__pic">
                                        <img src="img/blog/details/details-author.jpg" alt="">
                                    </div>
                                    <div class="blog__details__author__text">
                                        <h6>Michael Scofield</h6>
                                        <span>Admin</span>
                                    </div>
                                </div> -->
                            </div>
                            <div class="col-lg-6">
                                <!-- <div class="blog__details__widget">
                                    <ul>
                                        <li><span>Categories:</span> Food</li>
                                        <li><span>Tags:</span> All, Trending, Cooking, Healthy Food, Life Style</li>
                                    </ul>
                                    <div class="blog__details__social">
                                        <a href="#"><i class="fa fa-facebook"></i></a>
                                        <a href="#"><i class="fa fa-twitter"></i></a>
                                        <a href="#"><i class="fa fa-google-plus"></i></a>
                                        <a href="#"><i class="fa fa-linkedin"></i></a>
                                        <a href="#"><i class="fa fa-envelope"></i></a>
                                    </div>
                                </div> -->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Blog Details Section End -->

    <!-- Related Blog Section Begin -->
    
    <!-- Related Blog Section End -->

    <!-- Footer Section Begin -->
    <footer class="footer spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-6">
                    <div class="footer__about">
                        <div class="footer__about__logo">
                            <a href="./main.do"><h2>DressMaker</h2></a>
                        </div>
                        <ul>
                            <li>Address: 60-49 Road 11378 New York</li>
                            <li>Phone: 010-4920-****</li>
                            <li>Email: j38317_study@naver.com</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-4 col-md-6 col-sm-6 offset-lg-1">
                    
                </div>
                <div class="col-lg-4 col-md-12">
                    
                </div>
            </div>
            <div class="row">
                <div class="col-lg-12">
                    <div class="footer__copyright">
                        <div class="footer__copyright__text"><p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p></div>
                        <div class="footer__copyright__payment"><img src="img/payment-item.png" alt=""></div>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!-- Footer Section End -->

    <!-- Js Plugins -->
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <script src="js/jquery.slicknav.js"></script>
    <script src="js/mixitup.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/main.js"></script>



</body>

</html>
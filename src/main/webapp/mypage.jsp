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
    <script
	  src="https://code.jquery.com/jquery-3.6.0.min.js"
	  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	  crossorigin="anonymous">
	</script>
	   <script>
        // 유효성 검사 (사용자가 입력한 값들이 유효한 값의 형태인지)
        function validate(){
            // 유효성 검사 : 아이디, 비밀번호, 비밀번호 일치, 이름
    
            // input요소 객체들 가져다놓기 (작성된 값 아님!!)
            var userId = document.getElementById("id_lbl");
            var userPwd1 = document.getElementById("pwd_lbl");
            var userPwd2 = document.getElementById("pwd2_lbl");
            var userName = document.getElementById("name_lbl");
    
            // 1) 아이디 검사 
            //    영소문자, 숫자로만 총 4~12글자로 이뤄져야됨
            //    단, 첫 글자는 반드시 영소문자 여야됨
            var regExp = /^[a-z][a-z\d]{3,11}$/;
            if(!regExp.test(id_lbl.value)){
                alert("유효한 아이디를 입력해주세요");
                userId.select();
                return false;
            }
    
            // 2) 비밀번호 검사
            //    영문자(대소문자),숫자,특수문자(!@#$%^&*)로 총 4~15자 사이로 입력
            regExp = /^[a-z\d!@#$%^&*]{4,15}$/i;
            if(!regExp.test(pwd_lbl.value)){
                alert("유효한 비밀번호를 입력해주세요");
                pwd_lbl.value = "";
                pwd_lbl.focus();
                return false;
            }
    
            // 3) 비밀번호 일치
            if(pwd_lbl.value != pwd2_lbl.value){
                alert("동일한 비밀번호를 입력해주세요");
                pwd2_lbl.value = "";
                pwd2_lbl.focus();
                return false;
            }
    
            // 4) 이름
            //    한글(결합)로만 2글자 이상
            regExp = /^[가-힣]{2,}$/;
            if(!regExp.test(name_lbl.value)){
                alert("유효한 이름을 입력해주세요");
                name_lbl.select();
                return false;
            }
        }
    </script>
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
	            <li><a href="./boardList.do">Review</a></li>
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
                            <li class="active"><a href="./main.do"><spring:message code="message.main.home"/></a></li>
                            <li><a href="./productList.do"><spring:message code="message.main.dress"/></a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="./productList.do">셀프웨딩드레스</a></li>
                                    <li><a href="./ready.jsp">하우스드레스</a></li>
                                    <li><a href="./ready.jsp">들러리드레스</a></li>
                                    <li><a href="./ready.jsp">웨딩볼레로</a></li>
                                </ul>
                            </li>
                            <li><a href="./shoping-cart.do"><spring:message code="message.main.cart"/></a></li>
                            <li><a href="./boardList.do"><spring:message code="message.main.review"/></a></li>
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

    <!-- Breadcrumb Section Begin -->
    <section class="breadcrumb-section set-bg" data-setbg="img/productList1.jpg">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                    <div class="breadcrumb__text">
                        <h2>MY PAGE</h2>
                        <div class="breadcrumb__option">
                            <a href="./main.do">Home</a>
                            <span>My Page</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Breadcrumb Section End -->

    <!-- Checkout Section Begin -->
    <section class="checkout spad">
        <div class="container">
            
            <div class="checkout__form">
                <h4 style="text-align: center;">마이페이지</h4>
                
                
                
                
                
                <form action="./updateMember.do" name="regForm" id="regForm" method="post" onsubmit="return sendit()">
                
                	<div class="checkout__input">
                        <p>아이디</p>
                        <input type="text" name="mid" class = "input_id" id="id_lbl" placeholder="영어, 숫자 4 ~ 12글자의 아이디를 입력해주세요. *반드시 첫자는 영어" value="${mvo.mid}" required readonly="readonly"/>
                        <font id="checkId" size = "2" style="float: left;"></font>
                        <!-- <font id = "checkId" size = "2" style="float: right;"></font> -->
                    </div>
                	<div class="checkout__input">
                        <p>비밀번호</p>
                        <input type="password" name="mpw" class="pw" id="pwd_lbl" placeholder="4 ~ 15자의 비밀번호를 입력해주세요" value="${mvo.mpw}" required/>
                    </div>
                	<div class="checkout__input">
                        <p>비밀번호 확인</p>
                        <input type="password" name="mpw2" class="pw" id="pwd2_lbl" placeholder="비밀번호를 다시 한번 입력해주세요" value="${mvo.mpw}" required/>
                        <font id = "checkPw" size = "2" style="float: left;"></font>
                    </div>
                	<div class="checkout__input">
                        <p>이름</p>
                        <input type="text" name="mname" class="w100p" id="name_lbl" placeholder="두 글자 이상의 이름을 입력해주세요" value="${mvo.mname}" required/>
                    </div>
                	<div class="checkout__input">
                        <p>이메일</p>
                        <input type="text" name="mmail" id="email_lbl" title="이메일을 입력하세요" placeholder="E-mail@naver.com" value="${mvo.mmail}" required/>
                    </div>
                	<div class="checkout__input">
                        <p>구매목록${buyNo}</p>
                        <select>
							<c:forEach var="bi" items="${buyInfoList_buyInfo}">
								<option value="${bi.pnum}">${bi.pname}</option>
							</c:forEach>
						</select>
						
                    </div>
                
			       
			        <p style="float: right;">
			            <input type="submit" class="site-btn" value="수정하기" onclick="return validate();">

			        </p>
			    </form>
                
                
                
                
            </div>
        </div>
    </section>
    <!-- Checkout Section End -->

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
	
	<script>
		$('.pw').keyup(function() {

			let pass1 = $("#pwd_lbl").val(); // input_id에 입력되는 값
			let pass2 = $("#pwd2_lbl").val(); // input_id에 입력되는 값

			if (pass1 != "" || pass2 != "") {
				if (pass1 == pass2) {
					$("#checkPw").html('비밀번호가 일치합니다.');
					$("#checkPw").attr('color', 'green');
				} else {
					$("#checkPw").html('비밀번호가 일치하지 않습니다.');
					$("#checkPw").attr('color', 'red');
				}
			}

		})
	</script>

 

</body>

</html>
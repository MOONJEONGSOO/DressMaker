<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="hc" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<c:choose>
<c:when test="${member.mid=='admin'}">
   
     
      <li style="line-height: 47.39px;"><span>${member.mname}님 반갑습니다:)</span></li>      
      <li><a href="logout.do" class="button small" style="float: right;">로그아웃</a></li>
      <li><a href="memberList.do" class="button small" style="float: right;">회원관리페이지</a></li>
 
</c:when>
<c:when test="${member.mid!=null}">
  
      
	<li style="line-height: 47.39px;"><span>${member.mname}님 반갑습니다:)</span></li>      
	<li><a href="logout.do" class="button small">로그아웃</a></li>
	<li>
		<form action="mypage.do" method="post">
			<input type="hidden" name="mid" value="${member.mid}" >
			<input type="hidden" name="mpw" value="${member.mpw}" >
			<input type="submit" class="button small" value="마이페이지" >            
		</form>
	</li>
  <!--  background-color: #ffffff;
        background-color: rgba( 255, 255, 255, 0.5 ); -->
  
  <!-- input[type=submit] { width: 100%; background-color: orange; color: white; padding: 14px 20px; margin: 8px 0; border: none; border-radius: 4px; cursor: pointer; } -->


  
</c:when>
<c:otherwise>
   
      
	<li><a href="loginpage.do" class="button small" style="float: right; padding: 9px 12px;">로그인</a></li>
	<li><a href="signup.jsp" class="button small" style="float: right; padding: 9px 12px;">회원가입</a></li>
  
</c:otherwise>
</c:choose>
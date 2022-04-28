<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="mail" class="com.test.app.product.impl.SendMail"/>



<c:choose>

<c:when test="${member.mid!=null}">
  
      
  <a href="./updateProduct.do" class="primary-btn">PROCEED TO CHECKOUT</a>

  
</c:when>
<c:otherwise>
   
	<a href="./updateProduct.do" class="primary-btn" style="pointer-events: none;">로그인 후 구매 가능합니다</a>
  	<span></span>
</c:otherwise>
</c:choose>
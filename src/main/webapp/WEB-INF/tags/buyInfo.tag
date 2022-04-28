<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:choose>

<c:when test="${buyInfoList_buyInfo!=null}">
  
      
	<select name="pnum">
		<c:forEach var="bi" items="${buyInfoList_buyInfo}">
			<option value="${bi.pnum}">${bi.pname}</option>
		</c:forEach>
	</select>
  
</c:when>
<c:otherwise>
   
	${buyNo}
  
</c:otherwise>
</c:choose>
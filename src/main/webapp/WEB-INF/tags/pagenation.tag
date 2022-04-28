<%@ tag description="pagination" pageEncoding="UTF-8"%>
<%@ tag import="java.util.ArrayList" %>
<%@ attribute name="recordCount" type="java.lang.Integer" required="true" %> 		<!-- 게시글 전체 개수 -->
<%@ attribute name="pageSize" type="java.lang.Integer" required="true" %>			<!-- 몇개씩 보여줄건지 -->
<%@ attribute name="queryStringName" type="java.lang.String" required="true" %>		<!-- page 이름 -->
<%@ attribute name="psearch" type="java.lang.String" required="false" %>				<!-- 상품이름 -->
<%@ attribute name="pstring" type="java.lang.String" required="false" %>				<!-- 가격정보 -->


<%! 
private class Page { 
    int page; 
    String label;
    
    Page(int page, String label) {
        this.page = page;
        this.label = label;
    }
} 
%>

<%
int recordCount = (Integer)jspContext.getAttribute("recordCount");
int pageSize = (Integer)jspContext.getAttribute("pageSize");
String name = (String)jspContext.getAttribute("queryStringName");
String psearch = (String)jspContext.getAttribute("psearch");
String pstring = (String)jspContext.getAttribute("pstring");



int currentPage = 1;
if (request.getParameter(name) != null)
    currentPage = Integer.parseInt(request.getParameter(name));

int pageCount = recordCount / pageSize;
if (pageCount * pageSize < recordCount) ++pageCount;


String queryString = request.getQueryString();

//// 추가부분
if(queryString!=null){
	int idx = queryString.indexOf("&");
	System.out.println("페이지네이션 45번" + idx);
	if(idx!=-1){
		queryString=queryString.substring(0, idx);
	}
}
////여기까지

if (queryString == null)
    queryString = name + "=@@@";
else if (queryString.matches(".*" + name + "=[0-9]+.*"))
    queryString = queryString.replaceAll(name + "=[0-9]+", name + "=@@@");
else
    queryString = queryString + "&" + name + "=@@@";
// 검색 빠진부분 있으면 에러가 떠서 분기처리 해서 조절
String url;
if(pstring==""){
url= request.getAttribute("javax.servlet.forward.request_uri") + "?" + queryString + "&psearch=" + psearch;
	
}else{
	
url= request.getAttribute("javax.servlet.forward.request_uri") + "?" + queryString + "&psearch=" + psearch + "&pstring=" + pstring;
}
///////

if (currentPage > pageCount) currentPage = pageCount;
int base = ((currentPage - 1) / 10) * 10;

ArrayList<Page> pages = new ArrayList<Page>();
if (base > 0) pages.add(new Page(base, "&lt;"));
for (int i = 1; i <= 10; ++i) {
    int n = base + i;
    if (n > pageCount) break;
    pages.add(new Page(n, String.valueOf(n)));
}
int n = base + 11;
if (n <= pageCount)
    pages.add(new Page(n, "&gt;"));
%>
<table class="pagination" style="justify-content: center;">
  <tr>
    <% for (Page p : pages) { %>
     <td class='<%= p.page == currentPage ? "active" : "" %>'>
        <a href='<%= url.replace("@@@", String.valueOf(p.page)) %>'> <%= p.label %> </a>
    </td><% } %>
  </tr>
</table>


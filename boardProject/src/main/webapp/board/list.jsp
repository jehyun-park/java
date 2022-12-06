<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ page import = "java.util.List" %>
<%@ page import = "vo.BoardVO" %>
<%@ page import = "vo.PageVO" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ include file="/view/color.jsp"%>

<%!
   
    SimpleDateFormat sdf = 
        new SimpleDateFormat("yyyy-MM-dd HH:mm");
%>

<%
	List<BoardVO> articleList = (List<BoardVO>)request.getAttribute("articleList");
	PageVO pageVO = (PageVO)request.getAttribute("pageVO");
	int count = pageVO.getCount();
	int number = pageVO.getNumber();
	int currentPage = pageVO.getCurrentPage();
	int startPage = pageVO.getStartPage();
	int pageCount = pageVO.getPageCount();
	int endPage = pageVO.getEndPage();
%>

<html>
<head>
<title>게시판</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="<%=bodyback_c%>">
<center><b>글목록(전체 글:<%=count%>)</b>
<table width="700">
<tr>
    <td align="right" bgcolor="<%=value_c%>">
    <a href="boardWriteForm.bo">글쓰기</a>
    </td>
</table>

<%
    if (count == 0) {
%>
<table width="700" border="1" cellpadding="0" cellspacing="0">
<tr>
    <td align="center">
    게시판에 저장된 글이 없습니다.
    </td>
</table>

<%  } else {    %>
<table border="1" width="700" cellpadding="0" cellspacing="0" align="center"> 
    <tr height="30" bgcolor="<%=value_c%>"> 
      <td align="center"  width="50"  >번 호</td> 
      <td align="center"  width="250" >제   목</td> 
      <td align="center"  width="100" >작성자</td>
      <td align="center"  width="150" >작성일</td> 
      <td align="center"  width="50" >조 회</td> 
      <td align="center"  width="100" >IP</td>    
    </tr>
<%
for (int i = 0 ; i < articleList.size() ; i++) {
          BoardVO article = (BoardVO)articleList.get(i);
%>
   <tr height="30">
    <td align="center"  width="50" > <%=number--%></td>
    <td  width="250" >
	<%
	      int wid=0; 
	      if(article.getRe_level()>0){
	        wid=5*(article.getRe_level());
	%>
	  <img src="images/level.gif" width="<%=wid%>" height="16">
	  <img src="images/re.gif">
	<%}else{%>
	  <img src="images/level.gif" width="<%=wid%>" height="16">
	<%}%>
           
      <a href="boardContent.bo?num=<%=article.getNum()%>&pageNum=<%=currentPage%>"><%=article.getSubject() %></a> 
          <% if(article.getReadcount()>=20){%>
         <img src="images/hot.gif" border="0"  height="16"><%}%> 
         </td>
    <td align="center"  width="100"> 
       <a href="mailto:<%=article.getEmail()%>">
       <%=article.getWriter()%></a></td>
    <td align="center"  width="150">
    <%= sdf.format(article.getReg_date())%></td>
    <td align="center"  width="50"><%=article.getReadcount()%>
    </td>
    <td align="center" width="100" ><%=article.getIp()%></td>
  </tr>
     <%}%>
</table>
<%}%>

<%
    if (count > 0) {
        
        if (startPage > 10) { //첫번쨰 페이지 그룹이 아니면   
        	%>
        <a href="boardList.bo?pageNum=<%= startPage - 10 %>">[이전]</a>
<%      
		// 이전 그룹의 첫페이지로 이동
        }
        for (int i = startPage ; i <= endPage ; i++) {  %>
        <a href="boardList.bo?pageNum=<%= i %>">[<%= i %>]</a>
<%
        }
        if (endPage < pageCount) { //마지막 페이지 그룹이 아니면  
        %> 
        <a href="boardList.bo?pageNum=<%= startPage + 10 %>">[다음]</a>
<%
		// 다음 페이지 그룹의 첫페이지로 이동
        }
    }
%>
</center>
</body>
</html>
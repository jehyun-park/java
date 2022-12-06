<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<h1>Main Top</h1>
<jsp:include page="sub.jsp">
	<jsp:param name = "name" value = "aaa"/>
</jsp:include>

<h1>Main Bottom</h1>


</body>
</html>
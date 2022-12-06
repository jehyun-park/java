<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	pageContext.setAttribute("pageScope","pageValue");
	request.setAttribute("requestScope","requestValue");
	session.setAttribute("sessionScope","sessionValue");
	application.setAttribute("applicationScope","applicationValue");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="viewAttribute.jsp"></jsp:forward>
	
</body>
</html>
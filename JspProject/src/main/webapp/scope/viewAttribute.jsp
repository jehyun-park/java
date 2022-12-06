<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	page:<%=pageContext.getAttribute("pageScope") %><br>
	request:<%=request.getAttribute("requestScope") %><br>
	session:<%=session.getAttribute("sessionScope") %><br>
	application:<%=application.getAttribute("applicationScope") %><br>
</body>
</html>
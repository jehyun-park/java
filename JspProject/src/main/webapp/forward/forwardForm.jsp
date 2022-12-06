<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

forwardForm.jsp
<jsp:forward page="forwardTo.jsp"></jsp:forward>
<%--
	forward 액션태그를 만나기전에 응답한 모든 내용은 버퍼에서 버리고 그냥 포워딩된다.
 --%>
</body>
</html>
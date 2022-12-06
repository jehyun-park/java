<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	//스크립트릿에서 선언한 변수는 반드시 사용되기 전에 선언해야지 인식됨.
	String str2 = "11월 22일.";
%>

<%
	String str1 = "오늘은" + str2;
%>

<%-- <%!
	//선언부에서 선언하는 변수는 페이지 전체에서 인식이 되므로 변수를 사용한 후에 선언해도 변수가 인식됨
	String str2 = "11월 22일.";
%> --%>

</body>
</html>
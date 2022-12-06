<%@page import="vo.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%
	MemberVO loginMemberVO = (MemberVO)session.getAttribute("loginMemberVO");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	if(loginMemberVO == null){
%>
	<a href = "loginForm.html">로그인</a>
	<a href = "memberRegistForm.html">회원가임</a>
<%
	}
	else{
%>
	<a href = "logout">로그아웃</a>
<%
	}
%>

</body>
</html>
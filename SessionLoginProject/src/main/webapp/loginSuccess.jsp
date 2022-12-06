<%@page import="vo.MemberVO" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  
<%
	MemberVO loginMemberVO = (MemberVO)request.getAttribute("loginMemberVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인에 성공한 사용자 정보</h1>
	<b>이름:</b><%=loginMemberVO.getMemberName() %><br>
	<b>이메일:</b><%=loginMemberVO.getMemberEmail() %><br>
</body>
</html>
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
	<h1>�α��ο� ������ ����� ����</h1>
	<b>�̸�:</b><%=loginMemberVO.getMemberName() %><br>
	<b>�̸���:</b><%=loginMemberVO.getMemberEmail() %><br>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean id="member" class = "vo.memberVO"></jsp:useBean>
<jsp:setProperty name ="member" property="*"></jsp:setProperty>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	아이디: <jsp:getProperty property="memberId" name="member"/>
	이름: <jsp:getProperty property="memberName" name="member"/>
	주소: <jsp:getProperty property="memberAddr" name="member"/>
	이메일: <jsp:getProperty property="memberEmail" name="member"/>
</body>
</html>
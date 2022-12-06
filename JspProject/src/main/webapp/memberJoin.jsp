<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action = "memberRegist.jsp" method = POST>
	회원아이디: <input type = "text" name = "memberId"><br>
	회원이름: <input type = "text" name = "memberName"><br>
	회원주소: <input type = "text" name = "memberAddr"><br>
	회원이메일: <input type = "text" name = "memberEmail"><br>
	<input type = "submit" value="회원가입">
</form>
</body>
</html>
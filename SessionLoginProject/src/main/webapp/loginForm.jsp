<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String memberId = (String)session.getAttribute("memberId");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#LoginArea{
		width:300px;
		height:150px;
		margin:auto;
		text-align: center;
		border: 3px double orange
	}
	fieldset{
		text-align:center;
		border:none;
	}
	input[type = "submit"]{
		margin-top:15px;
		}

</style>
</head>
<body>

<section id = "LoginArea">
<form action = "login" method = "POST">
	<fieldset>
		<legend>아이디/비밀번호</legend>
		<label for = "memberId">아이디: </label>
		<input type = "text" name = "memberId" id = "memberId" value = "<%=memberId%>"><br>
		<label for = "memberPasswd">비밀번호: </label>
		<input type = "password" name = "memberPasswd" id = "memberPasswd"><br>
		<label for = "cookieUse">쿠키사용: </label>
		<input type = "checkbox" name = "cookieUse" id = "cookieUse"/><br>
		<input type = "submit" value = "로그인">		
	</fieldset>


</form>
</section>

</body>
</html>
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
		<legend>���̵�/��й�ȣ</legend>
		<label for = "memberId">���̵�: </label>
		<input type = "text" name = "memberId" id = "memberId" value = "<%=memberId%>"><br>
		<label for = "memberPasswd">��й�ȣ: </label>
		<input type = "password" name = "memberPasswd" id = "memberPasswd"><br>
		<label for = "cookieUse">��Ű���: </label>
		<input type = "checkbox" name = "cookieUse" id = "cookieUse"/><br>
		<input type = "submit" value = "�α���">		
	</fieldset>


</form>
</section>

</body>
</html>
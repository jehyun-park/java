<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<%
	boolean idExist = (boolean)request.getAttribute("idExist");
	String memberId = (String)request.getAttribute("memberId");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>

<script>
	function winClose(){
		opener.document.myForm.memberId.value = '<%=memberId%>';
		window.close(); // = self.close();, close();
	}
</script>

</head>
<body>

	<%
	if(idExist){
	%>
		<h1>다른 아이디 입력: </h1>
		<form action="idCheck" name = "myForm">
			<label for = "memberId">아이디: </label>
			<input type = "text" name = "memberId"  id = "memberId"/><br>
			<input type = "submit" value = "선택">
		</form>
	<%
	}
	else{
	%>
		<%=memberId %>는 사용가능한 아이디입니다.<br>
		<a href = "javascript:winClose()">확인</a>
	<%
	}
	%>

</body>
</html>
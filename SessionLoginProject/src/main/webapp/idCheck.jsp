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
		<h1>�ٸ� ���̵� �Է�: </h1>
		<form action="idCheck" name = "myForm">
			<label for = "memberId">���̵�: </label>
			<input type = "text" name = "memberId"  id = "memberId"/><br>
			<input type = "submit" value = "����">
		</form>
	<%
	}
	else{
	%>
		<%=memberId %>�� ��밡���� ���̵��Դϴ�.<br>
		<a href = "javascript:winClose()">Ȯ��</a>
	<%
	}
	%>

</body>
</html>
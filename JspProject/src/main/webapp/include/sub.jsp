<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>Sub Body</h1>
names :
<%
	String[] nameArray = request.getParameterValues("name");

	for(int i = 0; i < nameArray.length;i ++){
		%>
		name: <%=nameArray[i] %><br>
	<%		
	}
%>


one name: <%=request.getParameter("name") %>

</body>
</html>
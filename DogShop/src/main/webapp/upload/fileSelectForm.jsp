<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>  

<%! 
	public String getParam(HttpServletRequest request, String paramName){
	if(request.getParameter(paramName) != null){
		return request.getParameter(paramName);
	}
	else{
		return " ";
	}
}

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#basicInfoArea, #addFileArea{
		width:620px;
		margin:auto;
		border:1px solid orange;
	}
	table{
		width:600px;
		margin:auto;
	}
</style>

<%
	int fileCount = 0;
	if(request.getParameter("fileCount") != null){
		fileCount = Integer.parseInt(request.getParameter("fileCount"));
	}

%>
<script>
	function changeValue(index){
		var paramValue = document.form1.elements[index].value;
		document.form2.elements[index].value = paramValue;
	}
</script>



</head>
<body>
<section id = "basicInfoArea">
	<form method="POST" name="form1">
		<table>
			<tr>
				<td><label for = "user">작성자 : </label></td>
				<td>
					<input type = "text" name = "user" id = "user" value="<%=getParam(request, "user") %>" onkeyup = "changeValue(0)">
				</td>
			</tr>
			<tr>
				<td><label for = "title">제목 : </label></td>
				<td>
					<input type = "text" name = "title" id = "title" value="<%=getParam(request, "title") %>" onkeyup = "changeValue(1)">
				</td>
			</tr>
			<tr>
				<td><label for = "content">내용 : </label></td>
				<td>
					<input type = "text" name = "content" id = "content" value="<%=getParam(request, "content") %>" onkeyup = "changeValue(2)">
				</td>
			</tr>
			<tr>
				<td><label for = "fileCount">업로드할 파일수 : </label></td>
				<td>
					<input type = "NUMBER" name = "fileCount" id = "fileCount" value="<%=getParam(request, "fileCount") %>">
				</td>
			</tr>
			<tr>
				<td colspan="2" style="text-align:center">
					<input type = "submit"  value="확인">
				</td>
			</tr>
		</table>
	</form>
</section>

<section id = "addFileArea" style = "margin-top:20px;">
	<form action = "fileSelectPro.jsp" method = "POST" encType = "multipart/form-data" name ="form2" >
		<table>
			<tr>
				<td>
					<input type = "hidden" name = "txtUser" value = "<%=getParam(request,"user")%>" >
					<input type = "hidden" name = "txtTitle" value = "<%=getParam(request,"title")%>">
					<input type = "hidden" name = "txtContent" value = "<%=getParam(request,"content")%>" >
					
					<%
						for(int i=0; i<fileCount; i++){
					%>
					
						<input type = "file" name = "selectFile<%= i %>"/>
					<%
						}
					%>
				</td>
			</tr>
			<tr>
				<td>
					<input type = "submit" value = "업로드">
				</td>
			</tr>
		</table>
</form>


</section>

</body>
</html>










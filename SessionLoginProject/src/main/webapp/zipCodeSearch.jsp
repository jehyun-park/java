<%@page import="java.util.ArrayList"%>
<%@page import = "vo.AddressVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<AddressVO> addressList = (ArrayList<AddressVO>)request.getAttribute("addressList");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style = type ="text/css">
	#addressListArea{
		width:250px;
		margin: auto;
		border: 1px solid green;
	}
	
	table{
		width:240px;
		margin:auto;
		text-align:center;
	}
</style>
<script>
	function winClose(zipCode,memberAddress1 ){
		opener.document.myForm.zipCode.value = zipCode;
		opener.document.myForm.memberAddr1.value = memberAddress1;
		window.close();
	}
</script>
</head>
<body>
<%
	if(addressList != null){
%>
	<section id = "addressListArea">
		<table>
			<%
				for(int i = 0; i < addressList.size();i++){
					String memberAddress1 = addressList.get(i).getDou() + " " + addressList.get(i).getSi() + " " + addressList.get(i).getGugun() + 
							" " + addressList.get(i).getDong() + " " + addressList.get(i).getRo() + " " + addressList.get(i).getBunzi();
			%>
				<tr>
					<td>
					 	<a href = "javascript:winClose('<%=addressList.get(i).getZipCode()%>','<%=memberAddress1%>')"><%=addressList.get(i).getZipCode() %></a>
					</td>		
					<td>
						<%=memberAddress1%>
					</td>	
				</tr>
			<%
				}
			%>
			</table>
	</section>
<%
	}
%>
<h1>도로명 주소를 입력하세요</h1>
<form action="zipCodeSearch">
	<label for = "ro">도로명: </label>	
	<input type = "text" id = "ro" name = "ro"><br>
	<input type = "submit" value = "검색"/>
</form>
</body>
</html>
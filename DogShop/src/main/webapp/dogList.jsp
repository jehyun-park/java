<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "vo.DogVO" %>
<%@ page import = "java.util.ArrayList" %>
<%
	ArrayList<DogVO> dogList = (ArrayList<DogVO>)request.getAttribute("dogList");
	ArrayList<String> todayImageList = (ArrayList<String>)request.getAttribute("todayImageList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#dogListArea{
		width : 650px;
		margin : auto;
		border : 1px solid red;
	}
	#todayImageListArea{
		margin-top: 20px;
		width : 650px;
		margin : auto;
		border : 1px solid red;
	}
	table{
		width: 600px;
		margin: auto;
		text-align: center;	
	}
	h1{
		text-align: center;
	}
	.dogListImage{
		width : 150px;
		height : 150px;
		border : none;
	}
	.todayImage{
		width : 100px;
		height : 100px;
		border : none;
	}
</style>
</head>
<body>
	<section id = "dogListArea">
	<%
		if(dogList == null || dogList.size() == 0){
	%>
		<h1>등록된 개 상품이 없습니다.</h1>
	<%
		} else{
	%>
		<h1>개상품목록</h1>
		<table>
			<tr>
				<%
					for(int i = 0; i < dogList.size();i++){
				%>
					<td>
						<a href = "dogView.dog?dogId=<%=dogList.get(i).getDogid() %>">
						<img src="images/<%=dogList.get(i).getDogImage()%>.jpg"
						class = "dogListImage"/></a><br>
						<%=dogList.get(i).getDogKind() %><br>
						<%=dogList.get(i).getDogPrice() %>원
					</td>
				<%
				if((i+1)%4 == 0){
				%>
				</tr>
				<tr>				
				<%
				}
				%>					
										
				<%
					}
				%>
			</tr>
		</table>
	<%
		}
	%>			
	</section>
	
	<%
		if(todayImageList != null && todayImageList.size() != 0 ){
			
	%>
	<section id = "todayImageListArea">
		<h1>오늘 본 개 상품</h1>
		<table>
			<tr>
				<%
					for(int i = 0; i< todayImageList.size();i++){
				%>
					<td>
						<img src = "images/<%=todayImageList.get(i)%>.jpg" class = "todayImage"/>
					</td>
				<%
					}
				%>						
			</tr>
		</table>
	</section>
	<% 
		}
	%>
</body>
</html>
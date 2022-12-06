<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import ="vo.DogVO"%>
<%
	DogVO dogVO = (DogVO)request.getAttribute("dogVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<style>
	#wrap{
		width:800px;
		height: 400px; 
		margin : auto;
	}
	#top{
		height: 150px;
		background: green;
	}
	#main{
		height: 500px;
	}
	#main_left{
		width:200px;
		height:500px;
		float : left;
		background: red;
	}
	#main_right{
		width:600px;
		height: 500px;
		float : left;
		background: red;
	}
	#bottom{
		width:800px;
		height:150px;
		background: brown;
	}
	.bigImage{
		width: 200px;
		height: 500px;
	}
</style>
</head>
<body>
<section id="wrap">
	<header id="top">
		<h1>
		<span style = "float:left"><%=dogVO.getDogKind() %>개 정보</span>
		<span style = "float:right">조회수 : <%=dogVO.getDogReadCount() %></span>
		</h1>
	</header>
	<section id = "main">
		<aside id = "main_left">
			<img src="images/<%=dogVO.getDogImage()%>.jpg" class = "bigImage"/>
		</aside>
		<section id="main_right" style = "font-size: xx-Large;">
			<b>개 원산지 : <%=dogVO.getDogCountry() %></b></br>
			<b>개 신장 : <%=dogVO.getDogHeight() %></b></br>
			<b>개 체중 : <%=dogVO.getDogWeight() %></b></br>
			<b>개 가격 : <%=dogVO.getDogPrice() %></b></br>
			<b>개 설명 : <%=dogVO.getDogContent() %></b></br>
		</section>
	</section>
	<footer id="bottom" style= "font-size: xx-Larze; text-align: center;">
		<a href = "dogList.dog">쇼핑 계속하기</a>&nbsp;<a href = "dogCartAdd.dog?dogId=<%=dogVO.getDogid()%>">장바구니 담기</a>
	</footer>
</section>
</body>
</html>
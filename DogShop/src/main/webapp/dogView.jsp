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
		<span style = "float:left"><%=dogVO.getDogKind() %>�� ����</span>
		<span style = "float:right">��ȸ�� : <%=dogVO.getDogReadCount() %></span>
		</h1>
	</header>
	<section id = "main">
		<aside id = "main_left">
			<img src="images/<%=dogVO.getDogImage()%>.jpg" class = "bigImage"/>
		</aside>
		<section id="main_right" style = "font-size: xx-Large;">
			<b>�� ������ : <%=dogVO.getDogCountry() %></b></br>
			<b>�� ���� : <%=dogVO.getDogHeight() %></b></br>
			<b>�� ü�� : <%=dogVO.getDogWeight() %></b></br>
			<b>�� ���� : <%=dogVO.getDogPrice() %></b></br>
			<b>�� ���� : <%=dogVO.getDogContent() %></b></br>
		</section>
	</section>
	<footer id="bottom" style= "font-size: xx-Larze; text-align: center;">
		<a href = "dogList.dog">���� ����ϱ�</a>&nbsp;<a href = "dogCartAdd.dog?dogId=<%=dogVO.getDogid()%>">��ٱ��� ���</a>
	</footer>
</section>
</body>
</html>
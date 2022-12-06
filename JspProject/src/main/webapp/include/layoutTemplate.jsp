<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	String contentPage = request.getParameter("contentPage");

	if(contentPage == null){
		contentPage = "company.jsp";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style>
	#wrap{
		width:800px;
		margin:auto;
	}
	
	#top{
		height:150px;
		background:green;
	}
	#main{
		height:500px;
	}
	#main_left{
		width:200px;
		height:500px;
		float:left;
		background:yellow;
	}
	#main_right{
		width:600px;
		height:500px;
		float:left;
		background:orange;
	}
	#bottom{
		height:150px;
		background:gray;
		
	}
	
</style>
</head>
<body>

<section id = "wrap">
	<header id = "top">
		<jsp:include page="top.jsp"></jsp:include>
	</header>
	<section id = "main">
		<aside id = "main_left">
			<jsp:include page="menu.jsp"></jsp:include>
		</aside>
		<section id = "main_right">
			<jsp:include page="<%=contentPage%>"></jsp:include>
		</section>
	</section>
	<footer id = "bottom">
		<jsp:include page="bottom.jsp"></jsp:include>
	</footer>
</section>

</body>
</html>
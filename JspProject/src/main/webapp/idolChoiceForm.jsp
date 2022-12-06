<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<%=request.getContextPath() %>/idolChoice.jsp" method = "POST">
	<h1>좋아하는 아이돌 선택</h1>
	<input type = "checkbox" name = "idol" id = "idol1" value = "blackpink.jpg"/>블랙핑크
	<input type = "checkbox" name = "idol" id = "idol2" value = "girlsgeneration.jpg"/>소녀시대
	<input type = "checkbox" name = "idol" id = "idol3" value = "idle.jpg"/>아이들
	<input type = "checkbox" name = "idol" id = "idol4" value = "mamamoo.jpg"/>마마무<br>
	<input type = "submit" value = "선택"/>
</form>
</body>
</html>
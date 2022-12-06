<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    
    %>
    <%-- errorPage 속성으로 에러를 처리하는 방식이 우선수위가 제일 높기 때문에 다른 방식을 사용하려면 이 ㅅ혹성을 제거해야함
    errorPage="/error/showError.jsp"
    --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%=request.getParameter("name").toUpperCase() %>
</body>
</html>
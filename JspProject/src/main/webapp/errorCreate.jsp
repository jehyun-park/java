<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"
    
    %>
    <%-- errorPage �Ӽ����� ������ ó���ϴ� ����� �켱������ ���� ���� ������ �ٸ� ����� ����Ϸ��� �� ��Ȥ���� �����ؾ���
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
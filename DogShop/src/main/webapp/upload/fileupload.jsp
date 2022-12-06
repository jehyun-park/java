<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File" %>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//파일이 업로드될 실질적인 경로
	String realFolder= "";

	//파일이 업로드될 서버상의 폴더명
	String saveFolder = "fileSave";
	
	String encType = "UTF-8";
	
	//한번에 업로드 할 수 있는 바이트수
	int maxSize = 5 * 1024 * 1024; //5M

 	// 애플리케이션당 하나씩 생성되는 객체
	ServletContext context = getServletContext();
	
	//서버의 물리적인 경로 얻어오기
	realFolder = context.getRealPath(saveFolder);
	
	try{
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType, new DefaultFileRenamePolicy());
		Enumeration paramNames = multi.getParameterNames();
		
		while(paramNames.hasMoreElements()){
			String paramName = (String)paramNames.nextElement();
			String paramValue = multi.getParameter(paramName);
			out.println(paramName + " = " + paramValue);
			
		}
		
		out.println("-------------------------------");
		
		Enumeration fileNames = multi.getFileNames();
		
		while(fileNames.hasMoreElements()){
			String fileName = (String)fileNames.nextElement();
			
			String serverFileName = multi.getFilesystemName(fileName);
			String originalFileName = multi.getOriginalFileName(fileName);
			
			String mimeType = multi.getContentType(fileName);
			
			File file = multi.getFile(fileName);
			
			out.println("파라미터이름: " + fileName + "<br>");
			out.println("원래파일이름: " + originalFileName + "<br>");
			out.println("저장된 파일 이름: " + serverFileName + "<br>");
			out.println("마임타입: " + mimeType + "<br>");
			
			if(file != null){
				out.println("업로드된 파일크기:" + file.length());
				out.println("<br>");
			}
			
		}
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
</body> 
</html>
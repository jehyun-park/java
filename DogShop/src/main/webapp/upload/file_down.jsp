<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.io.FileInputStream" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String fileName = request.getParameter("file_name");
	String fileSave = "fileSave";
	ServletContext context = getServletContext();
	String  downloadPath = context.getRealPath(fileSave);
	
	String filePath = downloadPath + "/" + fileName;
	
	byte[] b = new byte[4096]; //입력스트림에서 한번에 읽어들일 크기
	FileInputStream fis = new FileInputStream(filePath);
	
	String mimeType = getServletContext().getMimeType(filePath);
	if(mimeType == null) mimeType = "application/octet-stream";
	
	response.setContentType(mimeType);
	
	//다운로드할 파일이 한글일때의 처리
	//IE 와 다른 브라우저를 구분해서 처리
	
	String userAgent = request.getHeader("User-Agent");
	
	boolean ie = (userAgent.indexOf("MSIE") > -1) || (userAgent.indexOf("Trident") > -1 );
	
	if(ie){
		fileName = URLEncoder.encode(fileName, "UTF-8");
	}
	else{
		fileName = new String(fileName.getBytes("UTF-8"), "iso-8859-1");
	}
	
	response.setHeader("Content-Disposition" , "attachment;fileName=" + fileName);
	
	ServletOutputStream out2 = response.getOutputStream();
	
	int numRead = -1; // 읽어들인 바이트 수를 저장하는 변수.
	while((numRead = fis.read(b,0,b.length)) != -1){
		out2.write(b,0,numRead);
	}
	
	out2.flush();
	out2.close();
	fis.close();
	
%>
</body>
</html>




<%@page import="vo.MemberVO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	ArrayList<String> al = new ArrayList<String>();
	al.add("aaa");
	al.add("bbb");
	al.add("ccc");
	
	request.setAttribute("al", al);
	
	HashMap<String, String> hashMap = new HashMap<String, String>();
	hashMap.put("aaa", "aValue");
	hashMap.put("bbb", "bValue");
	request.setAttribute("hashMap", hashMap);
	
	String[] strArray = new String[3];
	strArray[0] = "111";
	strArray[1] = "222";
	strArray[2] = "333";
	request.setAttribute("strArray", strArray);
	
	MemberVO member = new MemberVO();
	member.setName("������");
	request.setAttribute("member", member);
%>

${member.name }

��ü or Map(.���) : ${hashMap.aaa } - ${member.name }<br>
��ü or Map([]���) : ${hashMap["aaa"] } - ${member["name"]}<br>
<%-- �迭 or List(.���) : ${strArray.0 } - ${al.1 }<br> --%>
�迭 or List([]���) : ${strArray[0] } - ${al[1] }<br>
</body>
</html>
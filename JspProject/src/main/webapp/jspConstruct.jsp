<%@page pageEncoding="UTF-8" contentType = "text/html; charset = UTF-8" import = "java.util.*"
buffer = "8kb" %>

<%--
	클라이언트가 JSP 페이지로 요청을 하면
	JSP 페이지의 코드는 서블릿에 해당하느느 자바코드로 변환된 후 컴파일된 후 응답한다.
	
	%@: 지시자영역(directive)
	JSP 코드가 자바코드로 변환될 때 변환방식(변환정보)을 지시해주는 영역
	
	page: 페이지 정보를 제공
	include: 다른 JSP 페이지에 정의된 코드들을 합쳐서 자바코드로 변환하는 지시자. copyright 페이지, 공통적으로 사용하는 상수를 정의한 페이지
	taglib: JSTL(Java Standard Tag Library)를 사용할때 해당 파트의 접두사를 지정할때 사용
--%>

<%!
	public int add(int x, int y){
	return x + y;
}

	String memberVar = "멤버변수";
%>
<%--
	선언부(declaration) : 페이지에서 사용되는 메소드나 멤버변수를 정의하는 영역
--%>

<%
	String localVar = "로컬변수";
	out.println("localVar = " + localVar + "<br>");
	//out : 내장객체, 출력스트림
%>

<%--
	스크립트릿(scriptlet): 자바 제어문 같은 실질적인 연산을 처리하는 부분. 로컬변수 선언 
--%>


<%--
	나머지 영역은 모두 HTML 바디 영역으로 인식됨
 --%>
 
 멤버변수: <%=memberVar %><br>
 add(10,10) : <%=add(10,10) %><br>
 
 <%--
 	%= : Expression Tag
 	JSP 코드가 자바코드로 변환됐을때 out.print()로 변환됨. 따라서 Expression() Tag 안에서는 ;를 사용하면 안됨
  --%>
  
  <!-- 
  	HTML 주석: 자바코드로 변환될때 일반문자열로 변환되면 클라이언트로 일반 문자열로 응답됨
  	따라서, 클라이언트 화면에서 소스보기를 하면 그대로 보임.
   -->
   
   <%
   	//자바주석: 자바코드로 변환될때 일반문자열로 변환되지만 컴파일이 되지 않기 때문에 클라이언트 페이지로 응답이 안됨
   %>
   
   <%--
   	JSP 주석은 자바코드로 변환 자체가 안됨
    --%>
    
    
    
    <%--
    	+ 내장객체, JSP 액션태그, JSTL, EL, 각종 컴포넌트들(업로드 컴포넌트)... etc
     --%>
    
    
    
    
    
    
    
    
    
    
    
    
    




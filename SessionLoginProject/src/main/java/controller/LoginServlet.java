package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService;
import vo.MemberVO;


//페이지가 실행될때 
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	Cookie[] cookieArray = request.getCookies();
    	
    	String memberId = "";
    	String memberPasswd = "";
    	
    	if(cookieArray != null) {	
    		for (int i = 0; i < cookieArray.length; i++) {
				if(cookieArray[i].getName().contentEquals("memberId")) {
					memberId = cookieArray[i].getValue();
				}
				else if(cookieArray[i].getName().contentEquals("memberPasswd")) {
					memberPasswd = cookieArray[i].getValue();
				}
			}
    	}
    	LoginService loginService = new LoginService();
		
		try {
			MemberVO loginMemberVO = loginService.getLoginMember(memberId, memberPasswd);
			
			if (loginMemberVO == null) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("location.href= 'loginForm.html'");
				out.println("</script>");
				
			}
			else {	
				request.setAttribute("loginMemberVO", loginMemberVO);		
				RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
				dispatcher.forward(request, response);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
    }
    
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberId = request.getParameter("memberId");
		String memberPasswd = request.getParameter("memberPasswd");
		String cookieUse = request.getParameter("cookieUse");
		
		if(cookieUse != null) {
			Cookie idCookie = new Cookie("memberId", memberId);
			//쿠키 객체를 생성하면 기본 생존기간이 -1로 설정됨
			//즉, 브라우저가 열려있을때는 쿠키가 생존하지만 브라우저를 닫으면 즉시 소멸됨
			
			idCookie.setMaxAge(60*60*24); //단위는 초
			response.addCookie(idCookie);
			
			Cookie passwdCookie = new Cookie("memberPasswd", memberPasswd);
			passwdCookie.setMaxAge(60*60*24); //단위는 초
			response.addCookie(passwdCookie);
		}
		
		//System.out.println(memberId + "," + memberPasswd);
		
		LoginService loginService = new LoginService();
		
		try {
			MemberVO loginMemberVO = loginService.getLoginMember(memberId, memberPasswd);
			
			if (loginMemberVO == null) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인실패')");
				out.println("history.back()");
				out.println("</script>");
				
			}
			else {
				//servlet에서 데이터를 공유하는 방법
				
				//1.초기화 파라미터를 사용하는 방법
				//web.xml에 공유할 데이터를 정의하는 방법
				//스프링프레임워크 사용할때 사용
				
				//2.속성
				//2-1. 속성 생성
				//영역객체.setAttribute(String atrrName, Object attrValue)
				//2-2. 속성 사용
				//Object 영역객체.getAttribute(String attrName)
				
				//영역객체
				//page : 동일 페이지 내에서만 속성이 공유
				//request : 동일 요청을 처리하기 위해서 거치는 모든 페이지에서 공유
				//session : 사용(웹브라우저)마다 할당되는 영역
				//application : 특정애플리케이션 내에서는 공유되는 영역
				
				//request.setAttribute("loginMemberVO", loginMemberVO);
				
				HttpSession session = request.getSession();
				session.setAttribute("loginMemberVO", loginMemberVO);
				
				//서블릿에서 포워딩 방식
				// 1. 디스패치
				//페이지 전환이 서버 상에서 이루어짐
				//쿨라이언트에서 페이지 전환을 알 수 없다.
				//주소표시줄의 요청주소가 변경되지 않는다.
				//요청이 변경되지 않는다.
				//죽 , 서블릿의 request 객체가 jsp에 공유됨.
				
				//RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
				//dispatcher.forward(request, response);
				
				// 2.리다이렉트 방식
				//페이지 전환이 클라이언트 상에서 이루어짐
				//주소표실줄의 요청 URL이 변경됨
				//따라서 request를 공유하지 않는다.
				response.sendRedirect("index.jsp");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}













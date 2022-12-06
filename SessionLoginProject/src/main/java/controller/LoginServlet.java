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


//�������� ����ɶ� 
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
			//��Ű ��ü�� �����ϸ� �⺻ �����Ⱓ�� -1�� ������
			//��, �������� ������������ ��Ű�� ���������� �������� ������ ��� �Ҹ��
			
			idCookie.setMaxAge(60*60*24); //������ ��
			response.addCookie(idCookie);
			
			Cookie passwdCookie = new Cookie("memberPasswd", memberPasswd);
			passwdCookie.setMaxAge(60*60*24); //������ ��
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
				out.println("alert('�α��ν���')");
				out.println("history.back()");
				out.println("</script>");
				
			}
			else {
				//servlet���� �����͸� �����ϴ� ���
				
				//1.�ʱ�ȭ �Ķ���͸� ����ϴ� ���
				//web.xml�� ������ �����͸� �����ϴ� ���
				//�����������ӿ�ũ ����Ҷ� ���
				
				//2.�Ӽ�
				//2-1. �Ӽ� ����
				//������ü.setAttribute(String atrrName, Object attrValue)
				//2-2. �Ӽ� ���
				//Object ������ü.getAttribute(String attrName)
				
				//������ü
				//page : ���� ������ �������� �Ӽ��� ����
				//request : ���� ��û�� ó���ϱ� ���ؼ� ��ġ�� ��� ���������� ����
				//session : ���(��������)���� �Ҵ�Ǵ� ����
				//application : Ư�����ø����̼� �������� �����Ǵ� ����
				
				//request.setAttribute("loginMemberVO", loginMemberVO);
				
				HttpSession session = request.getSession();
				session.setAttribute("loginMemberVO", loginMemberVO);
				
				//�������� ������ ���
				// 1. ����ġ
				//������ ��ȯ�� ���� �󿡼� �̷����
				//����̾�Ʈ���� ������ ��ȯ�� �� �� ����.
				//�ּ�ǥ������ ��û�ּҰ� ������� �ʴ´�.
				//��û�� ������� �ʴ´�.
				//�� , ������ request ��ü�� jsp�� ������.
				
				//RequestDispatcher dispatcher = request.getRequestDispatcher("loginSuccess.jsp");
				//dispatcher.forward(request, response);
				
				// 2.�����̷�Ʈ ���
				//������ ��ȯ�� Ŭ���̾�Ʈ �󿡼� �̷����
				//�ּ�ǥ������ ��û URL�� �����
				//���� request�� �������� �ʴ´�.
				response.sendRedirect("index.jsp");
			
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}













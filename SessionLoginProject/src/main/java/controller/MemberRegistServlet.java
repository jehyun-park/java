package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberRegistService;
import vo.MemberVO;

/**
 * Servlet implementation class MemberRegistServlet
 */
@WebServlet("/memberRegist")
public class MemberRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("memberId");
		String memberName = request.getParameter("memberName");
		int memberAge = Integer.parseInt(request.getParameter("memberAge"));
		String zipCode = request.getParameter("zipCode");
		String memberAddr1 = request.getParameter("memberAddr1");
		String memberAddr2 = request.getParameter("memberAddr2");
		String memberEmail = request.getParameter("memberEmail");
		String memberGender = request.getParameter("memberGender");
		String memberPasswd = request.getParameter("memberPasswd2");
		int memberGeneration = Integer.parseInt(request.getParameter("memberGeneration"));
		
		// �����Ͻ� ������ ȣ���Ҷ� Ŭ���̾�Ʈ���� �Ķ���ͷ� ���۵� �����͵��� �ϳ��� ���ڷ� �������� �ʰ�
		// DTO (Data Transfer Object): Ŭ���̾�Ʈ���� ���۵� �Ķ���� ������ �Ӽ� ������ �����ؼ� ���� �����Ͻ� �޼ҵ�� ���ڷ� �����ϴ� �뵵 , setter.getter ���ǵ�
		// VO (Value Object): �ַ� �����ͺ��̽����� ��ȸ�� ���ڵ� �����͵��� ��ü�� ��ȯ. getter�� ����, �׷����� �ֱٿ��� ȥ���ؼ� ����
		
		MemberVO memberVO = new MemberVO();
		memberVO.setMemberAddr1(memberAddr1);
		memberVO.setMemberAddr2(memberAddr2);
		memberVO.setMemberAge(memberAge);
		memberVO.setMemberEmail(memberEmail);
		memberVO.setMemberGender(memberGender);
		memberVO.setMemberGeneration(memberGeneration);
		memberVO.setMemberId(memberId);
		memberVO.setMemberName(memberName);
		memberVO.setMemberPasswd(memberPasswd);
		memberVO.setZipCode(zipCode);
		
		MemberRegistService memberRegistService = new MemberRegistService();
		try {
		boolean registSuccess = memberRegistService.registMember(memberVO);
		
		
		if(registSuccess) {
			HttpSession session = request.getSession();
			session.setAttribute("memberId", memberId);
			response.sendRedirect("loginForm.jsp");
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('��Ͻ���')");
			out.println("history.back()"); //= history.go(-1)
			out.println("</script>");
			}
		}catch(Exception e) { 
				
				e.printStackTrace();
				
		
		}
	}

}

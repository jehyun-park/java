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
		
		// 비지니스 로직을 호출할때 클라이언트에서 파라미터로 전송된 데이터들은 하나씩 인자로 전달하지 않고
		// DTO (Data Transfer Object): 클라이언트에서 전송된 파라미터 값들을 속성 값으로 저장해서 모델의 비지니스 메소드로 인자로 전달하는 용도 , setter.getter 정의됨
		// VO (Value Object): 주로 데이터베이스에서 조회한 레코드 데이터들을 객체로 변환. getter만 정의, 그렇지만 최근에는 혼용해서 쓴다
		
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
			out.println("alert('등록실패')");
			out.println("history.back()"); //= history.go(-1)
			out.println("</script>");
			}
		}catch(Exception e) { 
				
				e.printStackTrace();
				
		
		}
	}

}

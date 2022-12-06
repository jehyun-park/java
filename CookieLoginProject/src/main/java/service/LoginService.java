package service;
import static db.JDBCUtil.*;


import java.sql.Connection;

import dao.MemberDAO;
import vo.MemberVO;
public class LoginService {
	public MemberVO getLoginMember(String memberId, String memberPasswd) throws Exception {
		// TODO Auto-generated method stub
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		MemberVO loginMember = memberDAO.selectLoginMember(memberId, memberPasswd);
		close(con);
		return loginMember;
	}
	
	
}

package service;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import ui.MemberUI;
import vo.MemberVO;
import static db.JDBCUtil.*;

public class MemberListService {

	public ArrayList<MemberVO> getMemberList()throws Exception {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		ArrayList<MemberVO> memberList = memberDAO.selectMemberList();
		
		return memberList;
//		return MemberUI.memberList;
	}
	
}
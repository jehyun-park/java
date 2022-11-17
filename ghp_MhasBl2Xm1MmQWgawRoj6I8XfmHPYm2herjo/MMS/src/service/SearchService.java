package service;

import static db.JDBCUtil.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MemberDAO;
import static db.JDBCUtil.*;
import ui.MemberUI;
import vo.MemberVO;

public class SearchService {

	public MemberVO searchByMemberId(String memberId)throws Exception {
			/*MemberVO searchedMemberVO = null;
			for (int i = 0; i < MemberUI.memberList.size(); i++) {
				if (memberId.contentEquals(MemberUI.memberList.get(i).getMemberId())) {
					searchedMemberVO = MemberUI.memberList.get(i);
					break;
				}
			}
			return searchedMemberVO;*/
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		MemberVO searchedMemberVO = memberDAO.selectSearchedMemberVO(memberId);
		close(con);
		return searchedMemberVO;
	}

	public ArrayList<MemberVO> searchByMemberGeneration(String memberGeneration)throws Exception {
		/*		ArrayList<MemberVO> searchedMemberList = new ArrayList<MemberVO>();
				for (int i = 0; i < MemberUI.memberList.size(); i++) {
					if (MemberUI.memberList.get(i).getMemberGeneration() == Integer.parseInt(memberGeneration)) {
						searchedMemberList.add(MemberUI.memberList.get(i));
					}
				}
				return searchedMemberList;*/
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		ArrayList<MemberVO> searchedMemberList = memberDAO.selectSearchedMemberList(memberGeneration);
		close(con);
		return searchedMemberList;
		
	}

}
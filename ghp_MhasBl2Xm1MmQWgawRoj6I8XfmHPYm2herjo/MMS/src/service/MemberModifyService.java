package service;

import static db.JDBCUtil.*;

import java.sql.Connection;

import dao.MemberDAO;
import ui.MemberUI;
import vo.MemberVO;

public class MemberModifyService {

	public MemberVO getOldMemberVO(String memberId)throws Exception {
		/*		MemberVO oldMemberVO = null;
				for (int i = 0; i < MemberUI.memberList.size(); i++) {
					if(MemberUI.memberList.get(i).getMemberId().contentEquals(memberId)) {
						oldMemberVO = MemberUI.memberList.get(i);
						break;
					}
				}
				return oldMemberVO;*/
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		MemberVO oldMemberVO = memberDAO.selectOldMemberVO(memberId);
		close(con);
		return oldMemberVO;
	}

	public boolean modifyMemberVO(MemberVO newMemberVO)throws Exception {
		/*		boolean modifySuccess = false;
				for (int i = 0; i < MemberUI.memberList.size(); i++) {
					if(MemberUI.memberList.get(i).getMemberId().contentEquals(newMemberVO.getMemberId())) {
						MemberUI.memberList.set(i, newMemberVO);
						modifySuccess = true;
						break;
					}
				}
				return modifySuccess;*/
		boolean modifySuccess = false;
		
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		int updateCount = memberDAO.updateMember(newMemberVO);
		if(updateCount > 0) {
			modifySuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return modifySuccess;
			
	}
}
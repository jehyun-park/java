package service;

import static db.JDBCUtil.close;
import static db.JDBCUtil.commit;
import static db.JDBCUtil.getConnection;
import static db.JDBCUtil.rollback;

import java.sql.Connection;

import dao.MemberDAO;
import ui.MemberUI;

public class MemberRemoveService {

	public boolean removeMemberVO(String memberId)throws Exception {
		/*boolean removeSuccess = false;
		for (int i = 0; i < MemberUI.memberList.size(); i++) {
			if(memberId.contentEquals(MemberUI.memberList.get(i).getMemberId())) {
				MemberUI.memberList.remove(i);
				removeSuccess = true;
				break;
			}
		}
		return removeSuccess;*/
		
		boolean removeSuccess = false;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		int deleteCount = memberDAO.deleteMember(memberId);
		if (deleteCount > 0 ) {
			removeSuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		close(con);
		return removeSuccess;
	}

}
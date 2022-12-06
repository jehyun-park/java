package service;
import static db.JDBCUtil.*;

import java.sql.Connection;

import dao.MemberDAO;

public class IdCheckService {

	public boolean existId(String memberId) {
		boolean idExist = false;
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);
		
		String dbmemberId = memberDAO.selectmemberId(memberId);
		if(dbmemberId != null) {
			idExist = true;
		}
		close(con);
		return idExist;
	}
	
}
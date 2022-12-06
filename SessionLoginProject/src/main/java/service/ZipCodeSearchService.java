package service;
import static db.JDBCUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import vo.AddressVO;
import dao.MemberDAO;

public class ZipCodeSearchService {

	public static ArrayList<AddressVO> getaddressList(String ro) {
		Connection con = getConnection();
		MemberDAO memberDAO = MemberDAO.getInstance();
		memberDAO.setConnection(con);

		ArrayList<AddressVO> addressList = memberDAO.selectAddressList(ro);
		close(con);
		return addressList;
	}

	
}
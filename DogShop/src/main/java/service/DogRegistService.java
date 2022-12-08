package service;
import static db.JDBCUtil.*;

import java.sql.Connection;

import dao.DogDAO;
import vo.DogVO;

public class DogRegistService {

	public boolean registDog(DogVO dogVO) throws Exception {
		// TODO Auto-generated method stub
		
		boolean registSuccess = false;
		
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		
		int insertCount = dogDAO.insertDog(dogVO);
		
		if(insertCount > 0) {
			commit(con);
			registSuccess = true;
		}
		else {
			rollback(con);
		}
		
		return registSuccess;
	}

}

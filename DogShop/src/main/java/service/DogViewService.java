package service;
import static db.JDBCUtil.*;

import java.sql.Connection;

import dao.DogDAO;
import vo.DogVO; 

public class DogViewService {
	
	public DogVO getDog(int dogId)throws Exception {
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		
		DogVO dogVO = dogDAO.selectDogVO(dogId);
		close(con);
		return dogVO;
	}

	
}
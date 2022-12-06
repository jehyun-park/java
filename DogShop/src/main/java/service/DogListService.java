package service;

import static db.JDBCUtil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.DogDAO;
import vo.DogVO;

public class DogListService {

	public ArrayList<DogVO> getDogList() throws Exception {
		Connection con = getConnection();
		DogDAO dogDAO = DogDAO.getInstance();
		dogDAO.setConnection(con);
		
		ArrayList<DogVO> dogList = dogDAO.selectDogList();
		close(con);
		
		return dogList;
	}
	
}


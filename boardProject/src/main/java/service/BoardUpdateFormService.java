package service;
import static db.JDBCUtil.*;

import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardVO;
public class BoardUpdateFormService {

	public BoardVO getUpdateArticle(int num) throws Exception {
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		BoardVO article = boardDAO.selectUpdateArticle(num);
		
		close(con);
		
		return article;
	}

	
	
}

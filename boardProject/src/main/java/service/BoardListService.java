package service;

import static db.JDBCUtil.*;
import java.util.List;
import java.sql.Connection;

import dao.BoardDAO;
import vo.BoardVO;
public class BoardListService {

	public int getArticelCount() throws Exception{
		// TODO Auto-generated method stub
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int articleCount = boardDAO.selectArticleCount();
		
		
		close(con);
		
		return articleCount;
	}

	public List<BoardVO> getArticles(int startRow, int pageSize) throws Exception{
		// TODO Auto-generated method stub
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		List<BoardVO> articleList = boardDAO.selectArticleList(startRow, pageSize);
		
		close(con);
		return articleList;
		
	}

}

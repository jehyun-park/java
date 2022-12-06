package dao;


import static db.JDBCUtil.*;
import vo.BoardVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;




public class BoardDAO {
	private Connection con;
	//singleton 패턴
	//객체를 하나만 생성해서 공유하는 패턴
	private static BoardDAO boardDAO;
	
	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static BoardDAO getInstance(){
		if(boardDAO == null) {
			//처음 호출되었으면...
			boardDAO = new BoardDAO();
		}
		return boardDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertArticle(BoardVO article) throws Exception {
		// TODO Auto-generated method stub
			int insertCount  = 0;
	        PreparedStatement pstmt = null;
			ResultSet rs = null;

			int num=article.getNum();
			int ref=article.getRef();
			int re_step=article.getRe_step();
			int re_level=article.getRe_level();
			
			int number=0;
			//새로운 관련글 번호를 저장할 변수
	         
			String sql = "";

	        try {
	            

	            pstmt = con.prepareStatement
	            		("select max(num) from board");
				rs = pstmt.executeQuery();
				
				if (rs.next()) //기존에 작성된 글이 있으면, 지금 작성한 글이 첫번째 글이 아니면
			      number=rs.getInt(1)+1; //지금까지 사용되지 않은 새로운 관련글 번호를 얻는 부분
			    else
			      number=1; 
			   
			    if (num!=0)   // 지금 작성한글이 답변글이면
			    {  
			      sql="update board set re_step=re_step+1 " +
			      		"where ref= ? and re_step> ?";
	              pstmt = con.prepareStatement(sql);
	              pstmt.setInt(1, ref);
				  pstmt.setInt(2, re_step);
				  pstmt.executeUpdate();
				  re_step=re_step+1;
				  re_level=re_level+1;
			     }else{
			  	  ref=number;
				  re_step=0;
				  re_level=0;
			     }	 
	            // 쿼리를 작성
	            sql = "insert into board" +
	           "(num,writer,email,subject,passwd,reg_date,";
	            sql+="ref,re_step,re_level,content,ip) " +
	            "values(board_seq.nextval,?,?,?,?,?,?,?,?,?,?)";

	            pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, article.getWriter());
	            pstmt.setString(2, article.getEmail());
	            pstmt.setString(3, article.getSubject());
	            pstmt.setString(4, article.getPasswd());
				pstmt.setTimestamp(5, article.getReg_date());
	            pstmt.setInt(6, ref);
	            pstmt.setInt(7, re_step);
	            pstmt.setInt(8, re_level);
				pstmt.setString(9, article.getContent());
				pstmt.setString(10, article.getIp());
				
	           insertCount =  pstmt.executeUpdate();
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
				close(rs);
				close(pstmt);
	        }
	        return insertCount;
	    }

	public int selectArticleCount() throws Exception {
		// TODO Auto-generated method stub
		
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        int articleCount = 0;

        try {
            
            pstmt = con.prepareStatement
            		("select count(*) from board");
            rs = pstmt.executeQuery();

            if (rs.next()) {
               articleCount = rs.getInt(1);
			}
        } catch(Exception ex) {
            ex.printStackTrace();
        } finally {
           close(rs);
           close(pstmt);
        }
		return articleCount;
		
	}

	public List<BoardVO> selectArticleList(int startRow, int pageSize) throws Exception {
		// TODO Auto-generated method stub
		
	        ResultSet rs = null;
	        List<BoardVO> articleList=null;
	        PreparedStatement pstmt = null;
	        try {
	            pstmt = con.prepareStatement(
	            		
	"select list2.* from(select rownum r, list1.*  " +
	"from(select *  from board order by ref desc, re_step asc)list1) " +
	"list2 where r between ? and ?");
	            
	            pstmt.setInt(1, startRow);
				pstmt.setInt(2, startRow + pageSize-1);
				rs = pstmt.executeQuery();
	          if (rs.next()) {
	                articleList = new ArrayList<BoardVO>();
	                BoardVO article = null;
	                do{
	                  article = new BoardVO();
	      article.setNum(rs.getInt("num"));
	      article.setWriter(rs.getString("writer"));
	                  article.setEmail(rs.getString("email"));
	                  article.setSubject(rs.getString("subject"));
	                  article.setPasswd(rs.getString("passwd"));
	         article.setReg_date(rs.getTimestamp("reg_date"));
	      article.setReadcount(rs.getInt("readcount"));
	                  article.setRef(rs.getInt("ref"));
	                  article.setRe_step(rs.getInt("re_step"));
	      article.setRe_level(rs.getInt("re_level"));
	                  article.setContent(rs.getString("content"));
	         article.setIp(rs.getString("ip")); 
	      
	                  articleList.add(article);
	                
	       }while(rs.next());
	   }
	        } catch(Exception ex) {
	            ex.printStackTrace();
	        } finally {
	           close(rs);
	           close(pstmt);
	        }
	  return articleList;
		
	}

		
	public BoardVO selectArticle(int num) throws Exception {
		// TODO Auto-generated method stub
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article=null;
		try {
			
			pstmt = con.prepareStatement(
					"update board set readcount=readcount+1 where num = ?");
			pstmt.setInt(1, num);
			int updateCount = pstmt.executeUpdate();
			if(updateCount > 0) {
				commit(con);
			}
			else {
				rollback(con);
			}
			
			pstmt = con.prepareStatement(
					"select * from board where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));     
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return article;
		
	}
	public BoardVO selectUpdateArticle(int num) throws Exception {
		// TODO Auto-generated method stub
		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BoardVO article=null;
		try {
			
			
			pstmt = con.prepareStatement(
					"select * from board where num = ?");
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				article = new BoardVO();
				article.setNum(rs.getInt("num"));
				article.setWriter(rs.getString("writer"));
				article.setEmail(rs.getString("email"));
				article.setSubject(rs.getString("subject"));
				article.setPasswd(rs.getString("passwd"));
				article.setReg_date(rs.getTimestamp("reg_date"));
				article.setReadcount(rs.getInt("readcount"));
				article.setRef(rs.getInt("ref"));
				article.setRe_step(rs.getInt("re_step"));
				article.setRe_level(rs.getInt("re_level"));
				article.setContent(rs.getString("content"));
				article.setIp(rs.getString("ip"));     
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return article;
		
	}

}
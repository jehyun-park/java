package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.DogVO;

import static db.JDBCUtil.*;

public class DogDAO {
	private Connection con;
	//singleton 패턴
	//객체를 하나만 생성해서 공유하는 패턴
	private static DogDAO DogDAO;
	
	private DogDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static DogDAO getInstance(){
		if(DogDAO == null) {
			//처음 호출되었으면...
			DogDAO = new DogDAO();
		}
		return DogDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public ArrayList<DogVO> selectDogList() throws Exception {
		ArrayList<DogVO> dogList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM dog";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dogList = new ArrayList<DogVO>();
				DogVO dogVO = null;
				do {
					dogVO = new DogVO();
					dogVO.setDogContent(rs.getString("dogContent"));
					dogVO.setDogCountry(rs.getString("dogCountry"));
					dogVO.setDogHeight(rs.getInt("dogHeight"));
					dogVO.setDogid(rs.getInt("dogId"));
					dogVO.setDogImage(rs.getString("dogImage"));
					dogVO.setDogKind(rs.getString("dogKind"));
					dogVO.setDogPrice(rs.getInt("dogPrice"));
					dogVO.setDogReadCount(rs.getInt("dogReadCount"));
					dogVO.setDogWeight(rs.getInt("dogWeight"));
					dogList.add(dogVO);
					
				} while (rs.next());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return dogList;
	}

	public DogVO selectDogVO(int dogId)throws Exception {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM dog WHERE dogId = ?";
		DogVO dogVO = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, dogId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
					dogVO = new DogVO();
					dogVO.setDogContent(rs.getString("dogContent"));
					dogVO.setDogCountry(rs.getString("dogCountry"));
					dogVO.setDogHeight(rs.getInt("dogHeight"));
					dogVO.setDogid(rs.getInt("dogId"));
					dogVO.setDogImage(rs.getString("dogImage"));
					dogVO.setDogKind(rs.getString("dogKind"));
					dogVO.setDogPrice(rs.getInt("dogPrice"));
					dogVO.setDogReadCount(rs.getInt("dogReadCount"));
					dogVO.setDogWeight(rs.getInt("dogWeight"));
					
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return dogVO;
	}

	public int insertDog(DogVO dogVO) throws Exception {
		// TODO Auto-generated method stub
		
		PreparedStatement pstmt = null;
		int insertCount = 0;
		String sql = "INSERT INTO dog(dogId, dogKind, dogPrice, dogImage, dogCountry, dogHeight, dogWeight, dogContent, dogReadCount)"
				+ "VALUES(dog_seq.nextval, ?,?,?,?,?,?,?,?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, dogVO.getDogKind());
			pstmt.setInt(2, dogVO.getDogPrice());
			pstmt.setString(3, dogVO.getDogImage());
			pstmt.setString(4, dogVO.getDogCountry());
			pstmt.setInt(5, dogVO.getDogHeight());
			pstmt.setInt(6, dogVO.getDogWeight());
			pstmt.setString(7, dogVO.getDogContent());
			pstmt.setInt(8, 0);
			
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		

		
		return insertCount;
	}
}
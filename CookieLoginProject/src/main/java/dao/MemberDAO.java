package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static db.JDBCUtil.*;
import vo.MemberVO;

import vo.MemberVO;

public class MemberDAO {
	private Connection con;
	//singleton 패턴
	//객체를 하나만 생성해서 공유하는 패턴
	private static MemberDAO memberDAO;
	
	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static MemberDAO getInstance()throws Exception {
		if(memberDAO == null) {
			//처음 호출되었으면...
			memberDAO = new MemberDAO();
		}
		return memberDAO;
	}

	public void setConnection(Connection con) {
		this.con = con;
	}

	public int insertMember(MemberVO newMemberVO) throws Exception {
		/*		Statement stmt = null;
				int insertCount = 0;
					String sql = "INSERT INTO member1(memberId,memberName,memberAge,memberAddr,memberEmail,memberGender,memberGeneration) "
							+ "VALUES('" + newMemberVO.getMemberId() + "','" + newMemberVO.getMemberName() + "','" 
							+ newMemberVO.getMemberAge()+ "','"+newMemberVO.getMemberAddr()+ "','"+newMemberVO.getMemberEmail()+"','"
							+newMemberVO.getMemberGender()+"'," + newMemberVO.getMemberGeneration()+")";
		
				try {
					stmt = con.createStatement();
					insertCount = stmt.executeUpdate(sql);
				}catch(SQLException e){
					e.printStackTrace();
					}
				finally {
						close(stmt);
				}
				
				return insertCount;
		*/	
		PreparedStatement pstmt = null;
		int insertCount = 0;
			String sql = "INSERT INTO member1(memberId,memberName,memberAge,memberAddr,memberEmail,memberGender,memberGeneration) "
					+ "VALUES(?,?,?,?,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMemberVO.getMemberId());
			pstmt.setString(2, newMemberVO.getMemberName());
			pstmt.setInt(3, newMemberVO.getMemberAge());
			pstmt.setString(4, newMemberVO.getMemberAddr());
			pstmt.setString(5, newMemberVO.getMemberEmail());
			pstmt.setString(6, newMemberVO.getMemberGender());
			pstmt.setInt(7, newMemberVO.getMemberGeneration());
			
			insertCount = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			}
		finally {
				close(pstmt);
		}
		
		return insertCount;
		}

	public ArrayList<MemberVO> selectMemberList()throws Exception {
		/*		// TODO Auto-generated method stub
				ArrayList<MemberVO> memberList = null;
				Statement stmt = null;
				ResultSet rs = null;
				String sql = "SELECT * FROM member1";
				
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						//SELECT 구문을 실행해서 반환된 레코드가 하나라도 있으면...
		
						memberList = new ArrayList<MemberVO>();
						
						MemberVO memberVO = null;
						
						
						do {
							memberVO = new MemberVO();
							memberVO.setMemberAddr(rs.getString("memberAddr"));
							memberVO.setMemberAge(rs.getInt("memberAge"));
							memberVO.setMemberEmail(rs.getString("memberEmail"));
							memberVO.setMemberGender(rs.getString("memberEmail"));
							memberVO.setMemberGeneration(rs.getInt("memberGeneration"));
							memberVO.setMemberId(rs.getString("memberId"));
							memberVO.setMemberName(rs.getString("memberName"));
							
							memberList.add(memberVO);
						} while (rs.next());
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				finally {
					close(rs);
					close(stmt);
					
					
				}
				
				return memberList;*/
		
		ArrayList<MemberVO> memberList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member1";
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//SELECT 구문을 실행해서 반환된 레코드가 하나라도 있으면...

				memberList = new ArrayList<MemberVO>();
				
				MemberVO memberVO = null;
				
				
				do {
					memberVO = new MemberVO();
					memberVO.setMemberAddr(rs.getString("memberAddr"));
					memberVO.setMemberAge(rs.getInt("memberAge"));
					memberVO.setMemberEmail(rs.getString("memberEmail"));
					memberVO.setMemberGender(rs.getString("memberEmail"));
					memberVO.setMemberGeneration(rs.getInt("memberGeneration"));
					memberVO.setMemberId(rs.getString("memberId"));
					memberVO.setMemberName(rs.getString("memberName"));
					
					memberList.add(memberVO);
				} while (rs.next());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			close(rs);
			close(pstmt);
			
			
		}
		
		return memberList;
	}

	public MemberVO selectLoginMember(String memberId, String memberPasswd)throws Exception {
		/*		MemberVO oldMemberVO = null;
				Statement stmt = null;
				ResultSet rs = null;
				String sql = "SELECT * FROM member1 WHERE memberId = '"+ memberId + "'";
				
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						//SELECT 구문을 실행해서 반환된 레코드가 하나라도 있으면...
		
							oldMemberVO = new MemberVO();
							oldMemberVO.setMemberAddr(rs.getString("memberAddr"));
							oldMemberVO.setMemberAge(rs.getInt("memberAge"));
							oldMemberVO.setMemberEmail(rs.getString("memberEmail"));
							oldMemberVO.setMemberGender(rs.getString("memberEmail"));
							oldMemberVO.setMemberGeneration(rs.getInt("memberGeneration"));
							oldMemberVO.setMemberId(rs.getString("memberId"));
							oldMemberVO.setMemberName(rs.getString("memberName"));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				finally {
					close(rs);
					close(stmt);
					
					
				}
				
				return oldMemberVO;*/
		
		MemberVO LoginMember = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member1 WHERE memberId = ? AND memberPasswd = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPasswd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//SELECT 구문을 실행해서 반환된 레코드가 하나라도 있으면...
				
				LoginMember = new MemberVO();
				LoginMember.setMemberAddr(rs.getString("memberAddr"));
				LoginMember.setMemberAge(rs.getInt("memberAge"));
				LoginMember.setMemberEmail(rs.getString("memberEmail"));
				LoginMember.setMemberGender(rs.getString("memberGender"));
				LoginMember.setMemberGeneration(rs.getInt("memberGeneration"));
				LoginMember.setMemberId(rs.getString("memberId"));
				LoginMember.setMemberName(rs.getString("memberName"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			close(rs);
			close(pstmt);
		}
		
		return LoginMember;
	}

	public int updateMember(MemberVO newMemberVO)throws Exception {
		/*		Statement stmt = null;
				int updateCount = 0;
				String sql = "UPDATE member1 SET memberName = '"+ newMemberVO.getMemberName() 
					+ "', memberAge = " + newMemberVO.getMemberAge()
					+ ", memberAddr = '" + newMemberVO.getMemberAddr()
					+ "', memberEmail = '" + newMemberVO.getMemberEmail()
					+ "', memberGender = '" + newMemberVO.getMemberGender()
					+ "', memberGeneration = " + newMemberVO.getMemberGeneration()
					+ " WHERE memberId = '" + newMemberVO.getMemberId() + "'";
				
				try {
					stmt = con.createStatement();
					updateCount = stmt.executeUpdate(sql);
				}catch(SQLException e){
					e.printStackTrace();
				}
				finally {
					close(stmt);
				}
				
				return updateCount;*/
		
		PreparedStatement pstmt = null;
		int updateCount = 0;
		String sql = "UPDATE member1 SET memberName = ?, memberAge = ?, memberAddr = ?, memberEmail = ?, memberGender = ?, "
		+ "memberGeneration = ? WHERE memberId = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, newMemberVO.getMemberName());
			pstmt.setInt(2, newMemberVO.getMemberAge());
			pstmt.setString(3, newMemberVO.getMemberAddr());
			pstmt.setString(4, newMemberVO.getMemberEmail());
			pstmt.setString(5, newMemberVO.getMemberGender());
			pstmt.setInt(6, newMemberVO.getMemberGeneration());
			pstmt.setString(7, newMemberVO.getMemberId());
			
			updateCount = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		
		return updateCount;
	}

	public int deleteMember(String memberId)throws Exception  {
		/*		Statement stmt = null;
				int deleteCount = 0;
				String sql = "DELETE member1 "
						+ "WHERE memberId = '" + memberId + "'";
				
				try {
					stmt = con.createStatement();
					deleteCount = stmt.executeUpdate(sql);
				}catch(SQLException e){
					e.printStackTrace();
				}
				finally {
					close(stmt);
				}
				
				return deleteCount;*/
		
		PreparedStatement pstmt = null;
		int deleteCount = 0;
		String sql = "DELETE member1 "
				+ "WHERE memberId = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			deleteCount = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			close(pstmt);
		}
		
		return deleteCount;
	}

	public MemberVO selectSearchedMemberVO(String memberId)throws Exception {
		/*		MemberVO searchedMemberVO = null;
				Statement stmt = null;
				ResultSet rs = null;
				String sql = "SELECT * FROM member1 WHERE memberId = '"+ memberId + "'";
				
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						//SELECT 구문을 실행해서 반환된 레코드가 하나라도 있으면...
		
							searchedMemberVO = new MemberVO();
							searchedMemberVO.setMemberAddr(rs.getString("memberAddr"));
							searchedMemberVO.setMemberAge(rs.getInt("memberAge"));
							searchedMemberVO.setMemberEmail(rs.getString("memberEmail"));
							searchedMemberVO.setMemberGender(rs.getString("memberEmail"));
							searchedMemberVO.setMemberGeneration(rs.getInt("memberGeneration"));
							searchedMemberVO.setMemberId(rs.getString("memberId"));
							searchedMemberVO.setMemberName(rs.getString("memberName"));
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				finally {
					close(rs);
					close(stmt);
					
					
				}
				
				return searchedMemberVO;*/
		
		
		MemberVO searchedMemberVO = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member1 WHERE memberId = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//SELECT 구문을 실행해서 반환된 레코드가 하나라도 있으면...
				
				searchedMemberVO = new MemberVO();
				searchedMemberVO.setMemberAddr(rs.getString("memberAddr"));
				searchedMemberVO.setMemberAge(rs.getInt("memberAge"));
				searchedMemberVO.setMemberEmail(rs.getString("memberEmail"));
				searchedMemberVO.setMemberGender(rs.getString("memberEmail"));
				searchedMemberVO.setMemberGeneration(rs.getInt("memberGeneration"));
				searchedMemberVO.setMemberId(rs.getString("memberId"));
				searchedMemberVO.setMemberName(rs.getString("memberName"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			close(rs);
			close(pstmt);
			
			
		}
		
		return searchedMemberVO;
	}

	public ArrayList<MemberVO> selectSearchedMemberList(String memberGeneration) {
		/*		ArrayList<MemberVO> searchedmemberList = null;
				Statement stmt = null;
				ResultSet rs = null;
				String sql = "SELECT * FROM member1 WHERE memberGeneration = " + memberGeneration;
				
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(sql);
					
					if(rs.next()) {
						//SELECT 구문을 실행해서 반환된 레코드가 하나라도 있으면...
		
						searchedmemberList = new ArrayList<MemberVO>();
						
						MemberVO memberVO = null;
						
						
						do {
							memberVO = new MemberVO();
							memberVO.setMemberAddr(rs.getString("memberAddr"));
							memberVO.setMemberAge(rs.getInt("memberAge"));
							memberVO.setMemberEmail(rs.getString("memberEmail"));
							memberVO.setMemberGender(rs.getString("memberEmail"));
							memberVO.setMemberGeneration(rs.getInt("memberGeneration"));
							memberVO.setMemberId(rs.getString("memberId"));
							memberVO.setMemberName(rs.getString("memberName"));
							
							searchedmemberList.add(memberVO);
						} while (rs.next());
						
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				finally {
					close(rs);
					close(stmt);
					
					
				}
				
				return searchedmemberList;*/
		
		
		ArrayList<MemberVO> searchedmemberList = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM member1 WHERE memberGeneration = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberGeneration);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				//SELECT 구문을 실행해서 반환된 레코드가 하나라도 있으면...
				
				searchedmemberList = new ArrayList<MemberVO>();
				
				MemberVO memberVO = null;
				
				
				do {
					memberVO = new MemberVO();
					memberVO.setMemberAddr(rs.getString("memberAddr"));
					memberVO.setMemberAge(rs.getInt("memberAge"));
					memberVO.setMemberEmail(rs.getString("memberEmail"));
					memberVO.setMemberGender(rs.getString("memberEmail"));
					memberVO.setMemberGeneration(rs.getInt("memberGeneration"));
					memberVO.setMemberId(rs.getString("memberId"));
					memberVO.setMemberName(rs.getString("memberName"));
					
					searchedmemberList.add(memberVO);
				} while (rs.next());
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			close(rs);
			close(pstmt);
			
			
		}
		
		return searchedmemberList;	
	}
}
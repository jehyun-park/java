import java.sql.*;

public class ConnectionTest {
	Connection con;
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	void connect() {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "java", "java");
			System.out.println("connection success!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void insert(String memberId, String memberName, int memberAge, String memberEmail, String memberGender,
			String memberBithday, String memberHomePage) {
		/*		Statement stmt = null;
				//1. INSERT INTO 테이블명 VALUES(data1,data2,data3...)
				//VALUES ()안에 나열되는 데이터의 개수는 컬럼의 개수와 동일해야 한다.
						String sql = "INSERT INTO member VALUES('" + memberId + "','"+memberName + "','"
						+memberAge+"','"+memberEmail+"','"+memberGender+"','"+memberBirthday+"')";
						
				
				//2. INSERT INTO 테이블명(컬럼명1, 컬럼명2, 컬럼명3, ...)
				//VALUES(data1,data2,data3,...)
				//VALUES()안에 나열되는 데이터의 개수가 테이블명 뒤에 나열되는 컬럼의 개수와 동일하면 된다.
				//NOT NULL 속성이 지정된 컬럼은 반드시 데이터를 삽입해야 됨.
				String sql = "INSERT INTO member(memberId,memberName,memberAge,memberEmail,memberGender,memberBithday,memberHomePage) VALUES('" + memberId + "','"+memberName + "','"
				+memberAge+"','"+memberEmail+"','"+memberGender+"','"+memberBithday+"','" + memberHomePage+"')";
		
			try {
				connect();
				stmt = con.createStatement();
				int insertCount = stmt.executeUpdate(sql);
				if(insertCount>0) {
					System.out.println("insert success");
				}
			}catch(SQLException e){
				e.printStackTrace();
				}
			finally {
				try {
					stmt.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
		//Statement stmt = null;
		//1. INSERT INTO 테이블명 VALUES(data1,data2,data3...)
		//VALUES ()안에 나열되는 데이터의 개수는 컬럼의 개수와 동일해야 한다.
		/*				String sql = "INSERT INTO member VALUES('" + memberId + "','"+memberName + "','"
						+memberAge+"','"+memberEmail+"','"+memberGender+"','"+memberBirthday+"')";
		*/				
		
		//2. INSERT INTO 테이블명(컬럼명1, 컬럼명2, 컬럼명3, ...)
		//VALUES(data1,data2,data3,...)
		//VALUES()안에 나열되는 데이터의 개수가 테이블명 뒤에 나열되는 컬럼의 개수와 동일하면 된다.
		//NOT NULL 속성이 지정된 컬럼은 반드시 데이터를 삽입해야 됨.
		String sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		PreparedStatement pstmt = null;
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberName);
			pstmt.setInt(3, memberAge);
			pstmt.setString(4, memberEmail);
			pstmt.setString(5, memberGender);
			pstmt.setString(6, memberBithday);
			pstmt.setString(7, memberHomePage);
			int insertCount = pstmt.executeUpdate();
			if(insertCount>0) {
				System.out.println("insert success");
			}
		}catch(SQLException e){
			e.printStackTrace();
			}
		finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	void selectAll() {
		String sql = "SELECT * FROM member";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("아이디 : " + rs.getString(1) + "이름 : " + rs.getString("memberName") + ", 나이 : "
						+ rs.getInt("memberAge"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	void selectByName(String memberName) {
		/*String sql = "SELECT * FROM member WHERE memberName = '" + memberName + "'";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		
			while (rs.next()) {
				System.out.println("아이디 : " + rs.getString(1) + "이름 : " + rs.getString("memberName") + ", 나이 : "
						+ rs.getInt("memberAge"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		String sql = "SELECT * FROM member WHERE memberName = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberName);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("아이디 : " + rs.getString(1) + "이름 : " + rs.getString("memberName") + ", 나이 : "
						+ rs.getInt("memberAge"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	void selectByFirstName(String memberName) {
		/*String sql = "SELECT * FROM member WHERE memberName LIKE '" + memberName + "%'";
		Statement stmt = null;
		ResultSet rs = null;
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
		
			while (rs.next()) {
				System.out.println("아이디 : " + rs.getString(1) + "이름 : " + rs.getString("memberName") + ", 나이 : "
						+ rs.getInt("memberAge"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		String sql = "SELECT * FROM member WHERE memberName LIKE ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberName +"%");
			rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println("아이디 : " + rs.getString(1) + "이름 : " + rs.getString("memberName") + ", 나이 : "
						+ rs.getInt("memberAge"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	void update(String memberId, String memberName, int memberAge, String memberEmail, String memberGender,
			String memberBithday, String memberHomePage) {
		/*Statement stmt = null;
		// UPDATE
		// UPDATE TABLE [테이블명]
		// SET 수정할컬럼명1 = 수정할값1
		// ,수정할컬럼2 = 수정할값2 ...
		// WHERE 조건
		String sql = "UPDATE member " + "SET memberName = '" + memberName + "'" + ", memberAge = " + memberAge
				+ ", memberEmail = '" + memberEmail + "'" + ", memberGender = '" + memberGender + "'"
				+ ", memberBithday = '" + memberBithday + "'" + ", memberHomePage = '" + memberHomePage + "'"
				+ " WHERE memberId = '" + memberId + "'";
		
		try {
			connect();
			stmt = con.createStatement();
			int updateCount = stmt.executeUpdate(sql);
			if (updateCount > 0) {
				System.out.println("update success");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		PreparedStatement pstmt = null;
		String sql = "UPDATE member " 
				+ "SET memberName = ?" 
				+ ", memberAge = ?"
				+ ", memberEmail = ?"
				+ ", memberGender = ?"
				+ ", memberBithday = ?"
				+ ", memberHomePage = ?" 
				+ " WHERE memberId = ?";
		
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberName);
			pstmt.setInt(2, memberAge);
			pstmt.setString(3, memberEmail);
			pstmt.setString(4, memberGender);
			pstmt.setString(5, memberBithday);
			pstmt.setString(6, memberHomePage);
			pstmt.setString(7, memberId);
			int updateCount = pstmt.executeUpdate();
			if (updateCount > 0) {
				System.out.println("update success");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	void delete(String memberId) {
		/*Statement stmt = null;
		// DELETE
		// DELETE 테이블명
		// WHERE 조건
		String sql = "DELETE member" + " WHERE memberId = '" + memberId + "'";
		try {
			connect();
			stmt = con.createStatement();
			int deleteCount = stmt.executeUpdate(sql);
			if (deleteCount > 0) {
				System.out.println("delete success");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}*/
		PreparedStatement pstmt = null;
		String sql = "DELETE member" + " WHERE memberId = ?";
		try {
			connect();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, memberId);
			int deleteCount = pstmt.executeUpdate();
			if (deleteCount > 0) {
				System.out.println("delete success");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		ConnectionTest ct = new ConnectionTest();
		// ct.connect();
		// ct.insert("eee", "배현모", 22, "bhm@naver.com", "m", "1999-12-17","http:");

		// System.out.println("이름이 배현모인 회원정보");
		// ct.selectByName("배현모");

		// System.out.println("배씨 성시를 가진 회원정보");
		// ct.selectByFirstName("배");

		// System.out.println("아이디가 eee인 회원정보 수정");
		// ct.update("eee", "배현모", 22, "bhm@naver.com", "m",
		// "1999-12-17","http:update");

		//		System.out.println("아이디가 bbb인 회원정보 삭제");
		//		ct.delete("bbb");
		//ct.selectAll();
		
		ct.insert("2", "bhm", 24, "tsi0520@naver.com", "m", "1999-12-17", "hhh");
		ct.selectAll();
		ct.selectByName("bhm");
		ct.selectByFirstName("배");
		ct.update("2", "bbb", 25, "tsi0520", "c", "1999-12-18", "ccc");
		ct.delete("2");
		ct.selectAll();
	}
}
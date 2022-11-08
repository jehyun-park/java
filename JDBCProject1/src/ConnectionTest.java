import java.sql.*;
public class ConnectionTest {
	Connection con;
	static {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		}
	}

	void connect() {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","java","java");
			System.out.println("SUCCESS");
		}	catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void insert(String memberId, String memberName, int memberAge, String memberEmail, String memberGender, String memberBirthday, String memberHomePage ) {
		Statement stmt = null;
		// 1. INSERT INTO 테이블명 VALUES(data1, data2,...)
		// VALUES() 안에 나열되는 데이터의 개수는 컬럼의 개수와 동일해야 함.
		/*
		 * String sql = "INSERT INTO member VALUES('" + memberId + "','" + memberName +
		 * "'," + memberAge +",'" + memberEmail + "','" + memberGender + "','" +
		 * memberBirthday + "')";
		 */
		
		
		// 2. INSERT INTO 테이블명 (컬럼명1, 컬럼명2, 컬럼명3,... )
		// VALUES(data1, data2, data3, ...)
		// VALUES() 안에 나열되는 데이터의 개수가 테이블명뒤에 나열된 컬럼의 개수와 동일해야 한다.
		// NOT NULL 속성이 지정된 컬럼은 반드시 데이터를 삽입해야 됨.
		
		  String sql = "INSERT INTO member(memberId, memberName, memberAge, memberEmail, memberGender, memberBirthday, memberHomePage) VALUES('" + memberId + "','" + memberName +
		  "'," + memberAge +",'" + memberEmail + "','" + memberGender + "','" +
		  memberBirthday + "','" + memberHomePage + "')";
		 
		
		
		try {
			connect();
			stmt = con.createStatement();
			int insertCount = stmt.executeUpdate(sql);
			if(insertCount > 0) {
				System.out.println("insert success");
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
	
	void selectAll() {

		String sql = "SELECT * FROM member";
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("아이디: " + rs.getString(1) + ", 이름: " + rs.getString("memberName") + ", 나이: " + rs.getInt("memberAge"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				con.close();
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	
	void selectByName(String memberName) {

		String sql = "SELECT * FROM member where memberName = '" + memberName + "'";
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			connect();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println("아이디: " + rs.getString(1) + ", 이름: " + rs.getString("memberName") + ", 나이: " + rs.getInt("memberAge"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
				con.close();
				rs.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectionTest ct = new ConnectionTest();
		//ct.connect();
		//ct.insert("ddd","jehyun",24,"jehyun@cu.ac.kr","M","2000-05-07","https://www.wpgus.co");
		ct.selectAll();
		System.out.println("이름이 가나다인 회원정보");
		ct.selectByName("가나다");
	}

}

















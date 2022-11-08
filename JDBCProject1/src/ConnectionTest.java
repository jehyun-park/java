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
		// 1. INSERT INTO ���̺�� VALUES(data1, data2,...)
		// VALUES() �ȿ� �����Ǵ� �������� ������ �÷��� ������ �����ؾ� ��.
		/*
		 * String sql = "INSERT INTO member VALUES('" + memberId + "','" + memberName +
		 * "'," + memberAge +",'" + memberEmail + "','" + memberGender + "','" +
		 * memberBirthday + "')";
		 */
		
		
		// 2. INSERT INTO ���̺�� (�÷���1, �÷���2, �÷���3,... )
		// VALUES(data1, data2, data3, ...)
		// VALUES() �ȿ� �����Ǵ� �������� ������ ���̺��ڿ� ������ �÷��� ������ �����ؾ� �Ѵ�.
		// NOT NULL �Ӽ��� ������ �÷��� �ݵ�� �����͸� �����ؾ� ��.
		
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
				System.out.println("���̵�: " + rs.getString(1) + ", �̸�: " + rs.getString("memberName") + ", ����: " + rs.getInt("memberAge"));
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
				System.out.println("���̵�: " + rs.getString(1) + ", �̸�: " + rs.getString("memberName") + ", ����: " + rs.getInt("memberAge"));
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
		System.out.println("�̸��� �������� ȸ������");
		ct.selectByName("������");
	}

}

















import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class TransactionTest {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		PreparedStatement  pstmt = null;
		boolean allSuccess = false;
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "java", "java");
			con.setAutoCommit( false);  
			String sql = "CREATE TABLE test1(id NUMBER PRIMARY KEY , name VARCHAR2(12))";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			sql = "INSERT INTO test1 VALUES(1, 'aaa')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			sql = "INSERT INTO test1 VALUES(2, 'bbb')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			sql = "INSERT INTO test1 VALUES(3, 'ccc')";
			pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
			
			allSuccess = true;
			
		}catch (SQLException e) {
			e.printStackTrace();
		
	}
	finally {
		try {
			if(allSuccess) {
				con.commit();
			}
			else {
				con.rollback();
			}
			pstmt.close();
			con.close();
		}catch (SQLException e) {
			
		}
	}
	}
}

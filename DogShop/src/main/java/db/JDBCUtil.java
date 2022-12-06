package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JDBCUtil {
	/*
	 * static { try { Class.forName("oracle.jdbc.driver.OracleDriver"); } catch
	 * (ClassNotFoundException e) { // TODO: handle exception e.printStackTrace(); }
	 * }
	 */
		
	/*
	 * public static Connection getConnection() { Connection con = null; try { con =
	 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","java",
	 * "java"); System.out.println("connection success!!"); } catch (SQLException e)
	 * { e.printStackTrace(); } return con; }
	 */
		
	public static Connection getConnection() {
			Connection con = null;
			try {
			      Context initCtx = new InitialContext();
			      //톰캣자체의 컨텍스트
			      Context envCtx = (Context) initCtx.lookup("java:comp/env");
			      //서버 컨테이너의 Resource 정의에 대한 컨텍스트
			      DataSource ds = (DataSource)envCtx.lookup("jdbc/jsptest");
			      con = ds.getConnection();
			      con.setAutoCommit(false);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt) {
		try {
			stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//트랜젝션 처리....
	public static void commit(Connection con) {
		try {
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void rollback(Connection con) {
		try {
			con.rollback();
		} catch (Exception e) {
		}
	}
}
/**
 * A Simple DataSource sample without using JNDI.
 * Please compare to DataSourceJNDI.java
 *
 * Please use jdk1.2 or later version
 */

// You need to import the java.sql package to use JDBC
package jap.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataSource {
	public static void main(String args[]) throws SQLException {
		String url = "jdbc:oracle:thin:@localhost:1521:orcl";
		String user = "zhanyang";
		String password = "g19880520";
		Connection conn;
		PreparedStatement ps;
		ResultSet rs;
		Statement st;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("test ok");
			getAll(conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		

	}
	
	
	private static void getAll(Connection conn) {
	    String sql = "select * from c_m_user";
	    PreparedStatement pstmt;
	    try {
	        pstmt = (PreparedStatement)conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        int col = rs.getMetaData().getColumnCount();
	        System.out.println("============================");
	        while (rs.next()) {
	            for (int i = 1; i <= col; i++) {
	                System.out.print(rs.getString(i) + "\t");
	                if ((i == 2) && (rs.getString(i).length() < 8)) {
	                    System.out.print("\t");
	                }
	             }
	            System.out.println("");
	        }
	            System.out.println("============================");
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}

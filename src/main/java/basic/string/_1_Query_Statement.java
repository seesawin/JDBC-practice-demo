package basic.string;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class _1_Query_Statement {

	public static void main(String[] args) {
		// server location
		String connUrl = "jdbc:mysql://202.182.103.76:3306/FRANK_DEV?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// connect to database to get the connection to do CRUD
			conn = DriverManager.getConnection(connUrl, "frank", "test1234");
			
			String SELECT_ALL = "select * from TB_STRING";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);
			
			/*
			 * specify the type you want
			 * ###################################################################
			 * #								 #								 #
			 * #		  MySQL Data Types		 #	  Can always be converted 	 #
			 * #								 #	 	to these Java types		 #
			 * #								 #								 #
			 * ###################################################################
			 * #								 #								 #
			 * #  CHAR, 						 #		java.lang.String,		 #
			 * #  VARCHAR, 						 #		java.io.InputStream,	 #
			 * #  BLOB,			 	 			 #		java.io.Reader,		 	 #
			 * #  TEXT, 					 	 #		java.sql.Blob,			 #
			 * #  ENUM, 					 	 #		java.sql.Clob,		 	 # 
			 * #  SET,	 			     	 	 #								 #
			 * #								 #								 #
			 * ###################################################################
			 * 
			 * 
			 *  MySQL Type      Java Type
			 *  ----------      ---------
			 *  CHAR            String
			 *  VARCHAR         String
			 *  LONGVARCHAR     String
			 *  BINARY          byte[]
			 *  VARBINARY       byte[]
			 *  LONGVARBINARY   byte[]
			 */

			// all type cast type to String
			while (rs.next()) {
				System.out.print(rs.getString(1) + ", ");
				System.out.print(rs.getString(2) + ", ");
				System.out.print(rs.getString(3) + ", ");
				System.out.print(rs.getString(4) + ", ");
				System.out.print(rs.getString(5) + ", ");
				System.out.println(rs.getString(6) + "");
			}
			
			System.out.println("__________________________________________________________________");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*
			 * When you are done with using your Connection, you need to explicitly close it by
			 * calling its close() method in order to release any other database resources (cursors,
			 * handles, etc) the connection may be holding on to.
			 * 
			 * Actually, the safe pattern in Java is to close your ResultSet, Statement, and
			 * Connection (in that order) in a finally block when you are done with them, something
			 * like that:
			 */
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) { /* ignored */
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) { /* ignored */
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) { /* ignored */
				}
			}
		}
	}

}

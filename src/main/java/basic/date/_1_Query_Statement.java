package basic.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import basic.AppConfig;

public class _1_Query_Statement {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// connect to database to get the connection to do CRUD
			conn = DriverManager.getConnection(AppConfig.CONN_URL, AppConfig.USER, AppConfig.PWD);
			
			String SELECT_ALL = "select * from TB_DATE";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);
			
			// auto cast type to String
			while (rs.next()) {
				System.out.print(rs.getString(1) + ", ");
				System.out.print(rs.getString(2) + ", ");
				System.out.print(rs.getString(3) + ", ");
				System.out.print(rs.getString(4) + ", ");
				System.out.println(rs.getString(5) + "");
			}
			
			System.out.println("__________________________________________________________________");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);
			
			// auto cast type to Date
			while (rs.next()) {
				System.out.print(rs.getDate("d_year_4") + ", ");
				System.out.print(rs.getDate("d_date") + ", ");
				System.out.print(rs.getDate("d_time") + ", ");
				System.out.print(rs.getDate("d_datetime") + ", ");
				System.out.println(rs.getDate("d_timestamp") + "");
			}
			
			System.out.println("__________________________________________________________________");
			
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
			 * #  DATE, 						 #		java.lang.String,		 #
			 * #  TIME, 						 #		java.sql.Date,	 		 #
			 * #  DATETIME,			 	 		 #		java.sql.Timestamp,		 #
			 * #  TIMESTAMP 					 #		java.sql.Time			 #
			 * #								 #								 #
			 * ###################################################################
			 * 
			 * 
			 *  MySQL Type      Java Type
			 *  ----------      ---------
			 *  DATE            java.sql.Date
			 *  TIME            java.sql.Time
			 *  TIMESTAMP       java.sql.Tiimestamp
			 */

			while (rs.next()) {
				System.out.print(rs.getDate("d_year_4") + ", ");
				System.out.print(rs.getDate("d_date") + ", ");
				System.out.print(rs.getTime("d_time") + ", ");
				System.out.print(rs.getTimestamp("d_datetime") + ", ");
				System.out.println(rs.getTimestamp("d_timestamp") + "");
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

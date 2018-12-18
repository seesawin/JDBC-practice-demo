package basic.number;

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
			
			String SELECT_ALL = "select * from TB_NUMBER";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_ALL);

			// all type cast to String
			while (rs.next()) {
				System.out.print(rs.getString(1) + ", ");
				System.out.print(rs.getString(2) + ", ");
				System.out.print(rs.getString(3) + ", ");
				System.out.print(rs.getString(4) + ", ");
				System.out.print(rs.getString(5) + ", ");
				System.out.print(rs.getString(6) + ", ");
				System.out.print(rs.getString(7) + ", ");
				System.out.print(rs.getString(8) + ", ");
				System.out.println(rs.getString(9) + "");
			}
			
			System.out.println("__________________________________________________________________");

			String SELECT_BY_CONDITION = "select * from TB_NUMBER";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_BY_CONDITION);
			
			// all type cast type to Int
//			while (rs.next()) {
//				System.out.print(rs.getInt(1) + ", ");
//				System.out.print(rs.getInt(2) + ", ");
//				System.out.print(rs.getInt(3) + ", ");
//				System.out.print(rs.getInt(4) + ", ");
//				System.out.print(rs.getInt(5) + ", ");
//				System.out.print(rs.getInt(6) + ", ");
//				System.out.print(rs.getInt(7) + ", ");
//				System.out.print(rs.getInt(8) + ", ");
//				System.out.println(rs.getInt(9) + "");
//			}
			
			System.out.println("__________________________________________________________________");
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_BY_CONDITION);
			
			// 
			/*
			 * specify the type you want
			 * ###################################################################
			 * #								 #								 #
			 * #		  MySQL Data Types		 #	  Can always be converted 	 #
			 * #								 #	 	to these Java types		 #
			 * #								 #								 #
			 * ###################################################################
			 * #								 #								 #
			 * #  FLOAT, 						 #		java.lang.String,		 #
			 * #  REAL, 						 #		java.lang.Short,		 #
			 * #  DOUBLE PRECISION,			 	 #		java.lang.Integer,		 #
			 * #  NUMERIC, 					 	 #		java.lang.Long,			 #
			 * #  DECIMAL, 					 	 #		java.lang.Double,		 # 
			 * #  TINYINT,	 			     	 #		java.math.BigDecimal	 #
			 * #  SMALLINT, 					 #								 # 
			 * #  MEDIUMINT, 					 #								 # 
			 * #  INTEGER, 					 	 #								 #  							 
			 * #  BIGINT						 #								 #	 
			 * #								 #								 #
			 * ###################################################################
			 * 
			 * 
			 *  MySQL Type      Java Type
			 *  ----------      ---------
			 *  NUMERIC         java.math.BigDecimal
			 *  DECIMAL         java.math.BigDecimal
			 *  TINYINT         byte
			 *  SMALLINT        short
			 *  INTEGER         int
			 *  BIGINT          long
			 *  REAL            float
			 *  FLOAT           double
			 *  DOUBLE          double
			 */
			while (rs.next()) {
				System.out.print(rs.getByte("n_tiny") + ", ");
				System.out.print(rs.getShort("n_small") + ", ");
				System.out.print(rs.getInt("n_mediun") + ", ");
				System.out.print(rs.getInt("n_int") + ", ");
				System.out.print(rs.getLong("n_big") + ", ");
				System.out.print(rs.getFloat("n_float") + ", ");
				System.out.print(rs.getDouble("n_doble") + ", ");
				System.out.print(rs.getBigDecimal("n_decimal") + ", ");
				System.out.println(rs.getBigDecimal("n_numeric") + "");
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

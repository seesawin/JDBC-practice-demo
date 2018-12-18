package basic.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import basic.AppConfig;

public class _2_Query_PreparedStatement {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(AppConfig.CONN_URL, AppConfig.USER, AppConfig.PWD);

			/*
			 * The problem with SQL injection is, that a user input is used as part of the SQL
			 * statement
			 */
			String d_year_4 = "'1901'";
			String d_datetime = "'2011-02-02 13:55:33'";

			String SELECT_ALL = "select * from TB_DATE";
			ps = conn.prepareStatement(SELECT_ALL);
			rs = ps.executeQuery();
			_2_Query_PreparedStatement.printRows(rs);

			// use MySQL function to cast String to Date
			String SELECT_BY_CONDITION = "select * from TB_DATE where d_year_4 = " + d_year_4 + " and d_datetime = STR_TO_DATE( " + d_datetime + ", '%Y-%m-%d %T')";
			ps = conn.prepareStatement(SELECT_BY_CONDITION);
			rs = ps.executeQuery();
			_2_Query_PreparedStatement.printRows(rs);

			/*
			 * By using prepared statements you can force the user input to be handled as the
			 * content of a parameter (and not as a part of the SQL command).
			 * 
			 * But if you don't use the user input as a parameter for your prepared statement but
			 * instead build your SQL command by joining strings together, you are still vulnerable
			 * to SQL injections even when using prepared statements.
			 */
			SELECT_BY_CONDITION = "select * from TB_DATE where d_year_4 = ? and d_datetime = STR_TO_DATE( ?, '%Y-%m-%d %T')";
			ps = conn.prepareStatement(SELECT_BY_CONDITION);
			ps.setString(1, "1901");
			ps.setString(2, "2011-02-02 13:55:33");
			rs = ps.executeQuery();
			_2_Query_PreparedStatement.printRows(rs);

			SELECT_BY_CONDITION = "select * from TB_DATE where d_year_4 = ? and d_datetime = ?";
			ps = conn.prepareStatement(SELECT_BY_CONDITION);
			ps.setString(1, "1901");

			// use java function to cast String to Timestamp
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			java.util.Date parsedDate = dateFormat.parse("2011-02-02 13:55:33");
			Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());

			ps.setTimestamp(2, timestamp);
			rs = ps.executeQuery();
			_2_Query_PreparedStatement.printRows(rs);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) { /* ignored */
				}
			}
			if (ps != null) {
				try {
					ps.close();
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

	public static void printRows(ResultSet rs) throws SQLException {
		while (rs.next()) {
			System.out.print(rs.getString("d_year_4") + ", ");
			System.out.print(rs.getString("d_date") + ", ");
			System.out.print(rs.getString("d_time") + ", ");
			System.out.print(rs.getString("d_datetime") + ", ");
			System.out.println(rs.getString("d_timestamp") + "");
		}
		System.out.println("__________________________________________________________________");
	}

}

package basic.number;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _2_Query_PreparedStatement {

	public static void main(String[] args) {
		String connUrl = "jdbc:mysql://202.182.103.76:3306/FRANK_DEV?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(connUrl, "frank", "test1234");

			/*
			 * The problem with SQL injection is, that a user input is used as part of the SQL
			 * statement
			 */
			String n_tiny = "127";

			String SELECT_ALL = "select * from TB_NUMBER where n_tiny = " + n_tiny;
			ps = conn.prepareStatement(SELECT_ALL);
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
			String SELECT_BY_CONDITION = "select * from TB_NUMBER where n_tiny = ? and n_small = ?";
			ps = conn.prepareStatement(SELECT_BY_CONDITION);
			ps.setShort(1, (short) 127);
			ps.setShort(2, (short) 32767);
			rs = ps.executeQuery();
			_2_Query_PreparedStatement.printRows(rs);

		} catch (SQLException e) {
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
			System.out.print(rs.getShort("n_tiny") + ", ");
			System.out.print(rs.getShort("n_small") + ", ");
			System.out.print(rs.getInt("n_mediun") + ", ");
			System.out.print(rs.getInt("n_int") + ", ");
			System.out.print(rs.getBigDecimal("n_big") + ", ");
			System.out.print(rs.getFloat("n_float") + ", ");
			System.out.print(rs.getDouble("n_doble") + ", ");
			System.out.print(rs.getBigDecimal("n_decimal") + ", ");
			System.out.println(rs.getBigDecimal("n_numeric") + "");
		}
		System.out.println("__________________________________________________________________");
	}

}

package basic.string;

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
			String s_nb_char = "'abcde'";

			String SELECT_ALL = "select * from TB_STRING where s_nb_char = " + s_nb_char;
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
			String SELECT_BY_CONDITION = "select * from TB_STRING where s_nb_char = ? and s_b_varchar = ?";
			ps = conn.prepareStatement(SELECT_BY_CONDITION);
			ps.setString(1, "abcde");
			ps.setString(2, "ABCDEFGHIJKLMN");
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
			System.out.print(rs.getString("s_nb_char") + ", ");
			System.out.print(rs.getString("s_nb_varchar") + ", ");
			System.out.print(rs.getString("s_nb_binary") + ", ");
			System.out.print(rs.getString("s_b_char") + ", ");
			System.out.print(rs.getString("s_b_varchar") + ", ");
			System.out.println(rs.getString("s_b_varbinary") + "");
		}
		System.out.println("__________________________________________________________________");
	}

}

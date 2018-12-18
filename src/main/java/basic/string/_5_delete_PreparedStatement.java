package basic.string;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import basic.AppConfig;

public class _5_delete_PreparedStatement {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DriverManager.getConnection(AppConfig.CONN_URL, AppConfig.USER, AppConfig.PWD);

			String DELETE = "delete from TB_STRING where s_nb_char = ?";
			ps = conn.prepareStatement(DELETE);
			ps.setString(1, "abcde");

			count = ps.executeUpdate();
			System.out.println("delete count : " + count);

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
}

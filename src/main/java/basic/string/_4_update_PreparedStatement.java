package basic.string;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import basic.AppConfig;

public class _4_update_PreparedStatement {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DriverManager.getConnection(AppConfig.CONN_URL, AppConfig.USER, AppConfig.PWD);
			
			String UPDATE = "update TB_STRING set s_nb_varchar = ?, s_nb_binary = ?, s_b_char = ?, s_b_varchar = ?, s_b_varbinary = ?"
					+ "where s_nb_char = ?";
			ps = conn.prepareStatement(UPDATE);
			ps.setString(1, "bbbbb");
			ps.setString(2, "ccccc");
			ps.setString(3, "ddddd");
			ps.setString(4, "eeeee");
			ps.setString(5, "fffff");
			ps.setString(6, "aaaaa");
			
			count = ps.executeUpdate();
			System.out.println("update count : " + count);

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

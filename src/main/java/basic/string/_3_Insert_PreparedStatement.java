package basic.string;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import basic.AppConfig;

public class _3_Insert_PreparedStatement {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DriverManager.getConnection(AppConfig.CONN_URL, AppConfig.USER, AppConfig.PWD);

			
			String INSERT = "insert into TB_STRING values ( ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(INSERT);
			ps.setString(1, "aaaaa");
			ps.setString(2, "bbbbb");
			ps.setString(3, "ccccc");
			ps.setString(4, "DDDDD");
			ps.setString(5, "EEEEE");
			ps.setString(6, "FFFFF");
			
			count = ps.executeUpdate();
			System.out.println("insert count : " + count);

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

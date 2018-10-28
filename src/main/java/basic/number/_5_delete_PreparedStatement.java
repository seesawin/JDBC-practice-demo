package basic.number;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _5_delete_PreparedStatement {

	public static void main(String[] args) {
		String connUrl = "jdbc:mysql://202.182.103.76:3306/FRANK_DEV?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try {
			conn = DriverManager.getConnection(connUrl, "frank", "test1234");

			String DELETE = "delete from TB_NUMBER where n_tiny = ?";
			ps = conn.prepareStatement(DELETE);
			ps.setByte(1, (byte) 127);

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

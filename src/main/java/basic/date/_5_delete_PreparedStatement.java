package basic.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import basic.AppConfig;
import util.DateUtil;

public class _5_delete_PreparedStatement {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DriverManager.getConnection(AppConfig.CONN_URL, AppConfig.USER, AppConfig.PWD);

			String DELETE = "delete from TB_DATE where d_year_4 = ?";
			ps = conn.prepareStatement(DELETE);
			String year = DateUtil.getSqlDateFromString("2011", "yyyy").toString().substring(0, 4);
			ps.setString(1, year);

			count = ps.executeUpdate();
			System.out.println("delete count : " + count);

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
}

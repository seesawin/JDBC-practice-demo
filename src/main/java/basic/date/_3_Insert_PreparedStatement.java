package basic.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import basic.AppConfig;
import util.DateUtil;

public class _3_Insert_PreparedStatement {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DriverManager.getConnection(AppConfig.CONN_URL, AppConfig.USER, AppConfig.PWD);

			String INSERT = "insert into TB_DATE values ( ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(INSERT);
			String year = DateUtil.getSqlDateFromString("2011", "yyyy").toString().substring(0, 4);
			ps.setString(1, year);
			ps.setDate(2, DateUtil.getSqlDateFromString("2011-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setTime(3, DateUtil.getTimeFromString("2011-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setTimestamp(4, DateUtil.getTimestampFromString("2011-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setTimestamp(5, DateUtil.getTimestampFromString("2011-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));

			count = ps.executeUpdate();
			System.out.println("insert count : " + count);

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

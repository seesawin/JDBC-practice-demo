package basic.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

import util.DateUtil;

public class _4_update_PreparedStatement {

	public static void main(String[] args) {
		String connUrl = "jdbc:mysql://202.182.103.76:3306/FRANK_DEV?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try {
			conn = DriverManager.getConnection(connUrl, "frank", "test1234");

			String UPDATE = "update TB_DATE set d_date = ?, d_time = ?, d_datetime = ?, d_timestamp = ?"
							+ "where d_year_4 = ?";
			ps = conn.prepareStatement(UPDATE);
			ps.setDate(1, DateUtil.getSqlDateFromString("2013-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setTime(2, DateUtil.getTimeFromString("2013-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setTimestamp(3, DateUtil.getTimestampFromString("2013-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setTimestamp(4, DateUtil.getTimestampFromString("2013-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			String year = DateUtil.getSqlDateFromString("2011", "yyyy").toString().substring(0, 4);
			ps.setString(5, year);

			count = ps.executeUpdate();
			System.out.println("update count : " + count);

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

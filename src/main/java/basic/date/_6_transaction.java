package basic.date;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DateUtil;
import basic.AppConfig;

public class _6_transaction {

	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;

		try {
			conn = DriverManager.getConnection(AppConfig.CONN_URL, AppConfig.USER, AppConfig.PWD);

			conn.setAutoCommit(false);

			/**************************************** select ********************************************/

			String year = "1914";

			String SELECT_BY_CONDITION = "select * from TB_DATE where d_year_4 = ?";
			ps = conn.prepareStatement(SELECT_BY_CONDITION);
			ps.setString(1, year);

			rs = ps.executeQuery();
			_6_transaction.printRows(rs);

			/**************************************** insert ********************************************/

			String INSERT = "insert into TB_DATE values ( ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(INSERT);
			ps.setString(1, year);
			ps.setDate(2, DateUtil.getSqlDateFromString("1999-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setTime(3, DateUtil.getTimeFromString("1999-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setTimestamp(4, DateUtil.getTimestampFromString("1999-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setTimestamp(5, DateUtil.getTimestampFromString("1999-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));

			count = ps.executeUpdate();
			System.out.println("insert count : " + count);

			String SELECT_ALL = "select * from TB_DATE";
			ps = conn.prepareStatement(SELECT_ALL);
			rs = ps.executeQuery();
			_6_transaction.printRows(rs);

			System.out.println("sleep 5 sec...");
			Thread.sleep(5000);

			/**************************************** update ********************************************/

			String UPDATE = "update TB_DATE set d_date = ?, d_time = ?, d_datetime = ?, d_timestamp = ?" + "where d_year_4 = ?";
			ps = conn.prepareStatement(UPDATE);
			ps.setDate(1, DateUtil.getSqlDateFromString("2013-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setTime(2, DateUtil.getTimeFromString("2013-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setTimestamp(3, DateUtil.getTimestampFromString("2013-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setTimestamp(4, DateUtil.getTimestampFromString("2013-02-02 13:55:33", "yyyy-MM-dd hh:mm:ss"));
			ps.setString(5, year);

			count = ps.executeUpdate();
			System.out.println("update count : " + count);

			ps = conn.prepareStatement(SELECT_ALL);
			rs = ps.executeQuery();
			_6_transaction.printRows(rs);

			System.out.println("sleep 5 sec...");
			Thread.sleep(5000);

			// if(1 == 1) {
			// throw new Exception("something wrong!");
			// }

			conn.commit();
			System.out.println("commit...");

		} catch (Exception e) {
			conn.rollback();
			System.out.println("rollback...");
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

package basic.number;

import java.math.BigDecimal;
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
			
			String INSERT = "insert into TB_NUMBER values ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(INSERT);
			ps.setByte(1, (byte) 127);
			ps.setShort(2, (short) 32767);
			ps.setInt(3, 8388607);
			ps.setInt(4, 2147483647);
//			ps.setLong(5, 9223372036854775807L);
			ps.setLong(5, new BigDecimal("9223372036854775807").longValue());
//			ps.setFloat(6, (float)111111111111111.1234567890);
			ps.setFloat(6, new Float("111111111111111.1234567890"));
//			ps.setDouble(7, (double)111111111111111.1234567890);
//			ps.setDouble(7, new Float("111111111111111.1234567890"));
			ps.setDouble(7, new Double("111111111111111.1234567890"));
			ps.setBigDecimal(8, new BigDecimal("111111111111111.1234567890"));
			ps.setBigDecimal(9, new BigDecimal("111111111111111.1234567890"));
			
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

package basic.number;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class _4_update_PreparedStatement {

	public static void main(String[] args) {
		String connUrl = "jdbc:mysql://202.182.103.76:3306/FRANK_DEV?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			conn = DriverManager.getConnection(connUrl, "frank", "test1234");
			
			String UPDATE = "update TB_NUMBER set n_small = ?, n_mediun = ?, n_int = ?"
					+ ", n_big = ?, n_float = ?, n_doble = ?, n_decimal = ?, n_numeric = ?"
					+ "where n_tiny = ?";
			ps = conn.prepareStatement(UPDATE);
			ps.setShort(1, (short) -32768);
			ps.setInt(2, -8388608);
			ps.setInt(3, -2147483648);
			ps.setLong(4, -9223372036854775808L);
//			ps.setLong(4, new BigDecimal("-9223372036854775807").longValue());
			ps.setFloat(5, (float)-111111111111111.1234567890);
//			ps.setFloat(5, new Float("-111111111111111.1234567890"));
			ps.setDouble(6, (double)-111111111111111.1234567890);
//			ps.setDouble(6, new Float("-111111111111111.1234567890"));
//			ps.setDouble(6, new Double("-111111111111111.1234567890"));
			ps.setBigDecimal(7, new BigDecimal("-111111111111111.1234567890"));
			ps.setBigDecimal(8, new BigDecimal("-111111111111111.1234567890"));
			ps.setByte(9, (byte) 127);
			
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

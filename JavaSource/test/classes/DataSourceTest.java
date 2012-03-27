package test.classes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DataSourceTest {
	public static void main(String[] args) throws Exception {
		testDataSource();
	}

	public static void testDataSource() throws NamingException, SQLException {
		final String sql = "select 1";
		InitialContext ic = new InitialContext();
		DataSource ds = (DataSource) ic.lookup("java:/amadorProDS");
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				System.out.println("Query '" + sql + "' returned " + rs.getString(1));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		}
	}
}

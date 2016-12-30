package DBConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database implements IDatabase {

	private Connection connection = null;
	
	private Statement statement = null;
	
	private ResultSet rs = null;
	
	Database(String driver, String url, String username, String password) throws ClassNotFoundException, SQLException {
		
		Class.forName(driver);
		
		connection = DriverManager.getConnection(url, username, password); 
	}
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		
		return this.connection;
	}

	public ResultSet ExcuteSQLStatement(String sql) {
		
		try {
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = statement.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return rs;
	}
	
	public void closeConnection(ResultSet rs) {
		 if (null != rs) {
			 try {
				 rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
		 if (null != connection) {
			 try {
				 connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
	}
}

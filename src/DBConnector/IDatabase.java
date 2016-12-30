package DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;

public interface IDatabase {

	public Connection getConnection() throws Exception;
	
	public ResultSet ExcuteSQLStatement(String sql) throws Exception;
	
	public void closeConnection(ResultSet rs);
	
}


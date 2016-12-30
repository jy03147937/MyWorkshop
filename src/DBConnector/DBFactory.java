package DBConnector;

import java.sql.SQLException;

public final class DBFactory {

	private static String SQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String SQL_URL = "jdbc:sqlserver://localhost;DatabaseName=IData";
	private static String SQL_USERNAME = "schneider";
	private static String SQL_PASSWORD = "schneider";

	private static Database database = null;
	
	static {
		/*
		 * 读取配置文件中的数据库配置
		*/
		SQL_DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		SQL_URL = "jdbc:sqlserver://localhost;DatabaseName=IData";
		SQL_USERNAME = "schneider";
		SQL_PASSWORD = "schneider";
	}
	
	private DBFactory() {
    }
	
	public static Database GetDatebase() throws ClassNotFoundException, SQLException {
        if (database == null) {
            synchronized (Database.class) {
                if (database == null) {
                	database = new Database(SQL_DRIVER, SQL_URL, SQL_USERNAME, SQL_PASSWORD);
                }
            }
        }
        
		return database;
	}
	
}


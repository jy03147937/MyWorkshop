package DBConnector;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Repository<T> implements IRepository {

	private T t;
	
	Repository(T t) {
		this.t = t;
	}
	
	public List<T> getListBySql(String sql) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		Database db = DBFactory.GetDatebase();
		
		ResultSet rs = db.ExcuteSQLStatement(sql);
		
		List<T> result = new ArrayList<T>();
		
		try {
			result = DBHelper.ResultSetReader(rs, t);
			
		} catch (NoSuchMethodException | SecurityException | IllegalArgumentException | InvocationTargetException e) {

			e.printStackTrace();
		} finally {
			db.closeConnection(rs);
		}
		
		return result;
	}
}

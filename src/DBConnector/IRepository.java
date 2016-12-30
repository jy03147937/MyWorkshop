package DBConnector;

import java.util.List;

public interface IRepository {
	
	public <T> List<T> getListBySql(String sql) throws Exception;

}

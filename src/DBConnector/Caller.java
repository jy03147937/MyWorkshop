package DBConnector;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class Caller {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {

		Repository<StockRelation> re = new Repository(new StockRelation());
		
		List<StockRelation> list = re.getListBySql("SELECT * FROM StockRelation");
		
	}

}

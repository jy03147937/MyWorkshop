package DBConnector;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {
	
	public static <T> List<T> ResultSetReader(ResultSet rs, T t) throws InstantiationException, IllegalAccessException, 
			SQLException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		
		MetaData metaData = new MetaData(rs.getMetaData());
		
		Boolean[] hasFieldAndMethods = metaData.hasFieldAndMethods(t);
		Method[] Set_Methods = metaData.getCorrespondingSetMethods(t);
				
		List<T> result = new ArrayList<T>();
		
		while (rs.next()) {
			
			T tTemp = (T)t.getClass().newInstance();
			
			for (int i = 1; i <= metaData.getLength(); i++) {
				
				if (hasFieldAndMethods[i-1]) {
					
					Method setMethod = Set_Methods[i-1];
					
					Class[] paramter = setMethod.getParameterTypes();
					
					setMethod.invoke(tTemp, rs.getObject(i));
					
				} else {
					continue;
				}
			}
			
			result.add(tTemp);
		}
		return result;
	}
}


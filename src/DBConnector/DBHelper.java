package DBConnector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class DBHelper implements IFieldTypeMapping {
	
	public static <T> List<T> ResultSetReader(ResultSet rs, T t) throws InstantiationException, IllegalAccessException, SQLException {
		
		Field[] fieldsOfEntity = t.getClass().getDeclaredFields();
		Method[] methodsOfEntity = t.getClass().getDeclaredMethods();
		
		ArrayList<String> columnName = new ArrayList<String>();
		ArrayList<Integer> columnType = new ArrayList<Integer>();  
		ArrayList<Integer> isColumnExistInEntity = new ArrayList<Integer>();
		ResultSetMetaData metaData = rs.getMetaData();
		for (int i = 1; i <= metaData.getColumnCount() ; i++) {
			
			columnName.add(metaData.getColumnName(i));
			columnType.add(metaData.getColumnType(i));
			isColumnExistInEntity.add(Integer.valueOf(findField(fieldsOfEntity, metaData.getColumnName(i))));
		}
		
		List<T> result = new ArrayList<T>();
		
		while (rs.next()) {
			
			T tTemp = (T)t.getClass().newInstance();
			
			for (int i = 1; i <= metaData.getColumnCount() ; i++) {
				
				if(rs.isFirst()) {
					int fieldIndex = findField(fieldsOfEntity, metaData.getColumnName(i));
				}
				
				if (fieldIndex >= 0) {
					
					Type[] types = methodsOfEntity[0].getGenericParameterTypes();
					
				} else {
					continue;
				}
			}
			
			result.add(tTemp);
		}
		return result;
	}
	
	public Boolean validateType(Field entityField, int columnType) throws Exception {
		if ((columnType == Types.CHAR ||
			columnType == Types.NVARCHAR ||
			columnType == Types.NCHAR ||
			columnType == Types.VARCHAR)
			&&
			(entityField.getGenericType().equals())) {
			
		}
	}
	
	private static int findField(Field[] fields, String objStr) {
		for(int i = 0; i < fields.length; i++) {
			if(fields[i].toString().contains(objStr)) {
				return i;
			}
		}
		return -1;
	}
	
}


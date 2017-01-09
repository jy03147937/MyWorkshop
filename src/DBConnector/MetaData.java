package DBConnector;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class MetaData {
	
	private ArrayList<Column> columns = new ArrayList<Column>();

	private int columnNums = 0;
	
	public MetaData(ResultSetMetaData metaData) throws SQLException {
		this.columnNums = metaData.getColumnCount();
		
		for (int i = 1; i <= metaData.getColumnCount() ; i++) {
			
			this.columns.add(new Column(metaData.getColumnName(i), metaData.getColumnType(i)));
		}
	}
	
	public Column get(int index) {
		return columns.get(index);
	}
	
	public int getLength() {
		return columns.size();
	}
	/*
	 * Returned value: 
	 */
	public <T> Boolean[] hasFieldAndMethods(T t) {
		Boolean[] isInEntity = new Boolean[this.columnNums];
		
		Field[] fieldsOfEntity = t.getClass().getDeclaredFields();
		Method[] methodsOfEntity = t.getClass().getMethods();
		for (int i = 0; i < this.columnNums; i++) {
			Column column = this.columns.get(i);
			if(hasField(fieldsOfEntity, column)
				&& has_Get_Methods(methodsOfEntity, column) != null
				&& has_Set_Methods(methodsOfEntity, column) != null) {
				isInEntity[i] = true;
			} else {
				isInEntity[i] = false;
			}
		}
		
		return isInEntity;
	}
	
	public <T> Method[] getCorrespondingSetMethods(T t) {
		Method[] methodsOfEntity = t.getClass().getMethods();
		
		Method[] methods = new Method[this.columnNums];
		
		for(int i = 0; i < this.columnNums; i++) {
			Column column = this.columns.get(i);
			
			methods[i] = has_Set_Methods(methodsOfEntity, column);
		}
		
		return methods;
	}
	
	private Boolean hasField(Field[] fields, Column column) {
		for(int i = 0; i < fields.length; i++) {
			if(fields[i].toString().contains(column.getColumnName())) {
				return true;
			}
		}
		return false;
	}
	
	private Method has_Get_Methods(Method[] methodsOfEntity, Column column) {
		Method resultMethod = null;
		
		for(Method method : methodsOfEntity) {
			Class[] parameters = method.getParameterTypes();
			
			if(method.getName().equals("get" + column.getColumnName())
				&& parameters.length == 0) {
				resultMethod = method;
			}
			
		}
		
		return resultMethod;
	}
	
	private Method has_Set_Methods(Method[] methodsOfEntity, Column column) {
		Method resultMethod = null;
		
		for(Method method : methodsOfEntity) {
			Class[] parameters = method.getParameterTypes();
			
			if(method.getName().equals("set" + column.getColumnName())
				&& parameters.length == 1) {
				resultMethod = method;
			}
		}
		
		return resultMethod;
	}

}

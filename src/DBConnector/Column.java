package DBConnector;

public class Column {

	private String columnName = "";
	private int columnType = -1;
	
	public Column (String columnName, int columnType) {
		this.columnName = columnName;
		this.columnType = columnType;
	}
	public String getColumnName() {
		return this.columnName;
	}
	public int getColumnType() {
		return this.columnType;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public void setColumnType(int columnType) {
		this.columnType = columnType;
	}

}

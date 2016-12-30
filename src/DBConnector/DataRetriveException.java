package DBConnector;

public class DataRetriveException extends Exception {

	public static final String STRING_TO_NUM_EXP = "Can not convert nvarchar/vchar to number.";
	public static final String STRING_TO_DATETIME_EXP = "Format exception occurs when converting nvarchar/vchar to date time.";
	public static final String NUM_TO_DATETIME_EXP = "Can not convert number to date time.";
	public static final String DATETIME_TO_NUM_EXP = "Can not convert date time to number.";

	DataRetriveException (String msg) {
		super(msg);
	}
}

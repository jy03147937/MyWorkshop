package Controls;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Controls.DatetimeFormatException;

public class DateTime {
	
	public static void main(String[] args) {
		
		DateTime dt = new DateTime();
		
		try {
			dt = new DateTime("2016-11-23 02:23:44");
			
			System.out.println(dt.toString());
		} catch (DatetimeFormatException e) {
			
			e.printStackTrace();

		}
	}
	
	int year = 1988;
	
	int month = 7;
	
	int day = 27;
	
	int hour = 7;
	
	int minute = 10;
	
	int second = 0;
	
	DateTime () {
		Date dt = new Date();
		GregorianCalendar c = new GregorianCalendar();
		c.setTime(dt);
		
		this.year = c.get(Calendar.YEAR);
		this.month = c.get(Calendar.MONTH);
		this.day = c.get(Calendar.DAY_OF_MONTH);
		this.hour = c.get(Calendar.HOUR);
		this.minute = c.get(Calendar.MINUTE);
		this.second = c.get(Calendar.SECOND);
	}
	
	DateTime (String datetime) throws DatetimeFormatException {
		String reg = "\\b\\d{1,4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}\\b";
		Boolean isMatch = datetime.matches(reg);
		if(!isMatch) {
			throw new DatetimeFormatException("The input string is not the format: yy-mm-ss h-m-s");
		}
		
		String[] strA = datetime.split("\\D");

		this.year = Integer.parseInt(strA[0]);
		this.month = Integer.parseInt(strA[1]);
		this.day = Integer.parseInt(strA[2]);
		this.hour = Integer.parseInt(strA[3]);
		this.minute = Integer.parseInt(strA[4]);
		this.second = Integer.parseInt(strA[5]);
		
	}
	
	public static DateTime Parse (String datetime) throws DatetimeFormatException {
		
		String reg = "\\b\\d{1,4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}\\b";
		Boolean isMatch = datetime.matches(reg);
		if(!isMatch) {
			throw new DatetimeFormatException("The input string is not the format: yy-mm-ss h-m-s");
		}
		
		DateTime dt = new DateTime();
		
		String[] strA = datetime.split("\\D");

		dt.year = Integer.parseInt(strA[0]);
		dt.month = Integer.parseInt(strA[1]);
		dt.day = Integer.parseInt(strA[2]);
		dt.hour = Integer.parseInt(strA[3]);
		dt.minute = Integer.parseInt(strA[4]);
		dt.second = Integer.parseInt(strA[5]);
		
		return dt;
	}
	
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		str.append(String.valueOf(this.year).length() == 1 ? "0" + String.valueOf(this.year) : String.valueOf(this.year));
		str.append("-");
		str.append(String.valueOf(this.month).length() == 1 ? "0" + String.valueOf(this.month) : String.valueOf(this.month));
		str.append("-");
		str.append(String.valueOf(this.day).length() == 1 ? "0" + String.valueOf(this.day) : String.valueOf(this.day));
		str.append(" ");
		str.append(String.valueOf(this.hour).length() == 1 ? "0" + String.valueOf(this.hour) : String.valueOf(this.hour));
		str.append(":");
		str.append(String.valueOf(this.minute).length() == 1 ? "0" + String.valueOf(this.minute) : String.valueOf(this.minute));
		str.append(":");
		str.append(String.valueOf(this.second).length() == 1 ? "0" + String.valueOf(this.second) : String.valueOf(this.second));
		
		return str.toString();
	}
}

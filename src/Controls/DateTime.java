package Controls;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import Controls.DatetimeFormatException;

public class DateTime {
	
	public static void main(String[] args) {
		
		DateTime dt = new DateTime();
		
		try {
			
			
			dt = new DateTime("2017-01-15");
			System.out.println(dt.getDayOfYear());
			DateTime newDt = dt.addDays(26.54f);
			
			System.out.println(dt.toString());
			
			System.out.println(newDt.toString());
			
			System.out.println(convertYoungSecondsToDateTime(3600 * 24 * 365 * 6 + 8 * 3600 + 45 * 60 + 64));

		} catch (DatetimeFormatException e) {
			
			e.printStackTrace();

		}
	}
	
	private int year = 1988;
	
	private int month = 7;
	
	private int day = 27;
	
	private int hour = 7;
	
	private int minute = 10;
	
	private int second = 0;
	
	
	public DateTime () {
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
	
	public DateTime (String datetime) throws DatetimeFormatException {
		String reg = "\\b\\d{1,4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{1,2}:\\d{1,2}\\b|\\b\\d{1,4}-\\d{1,2}-\\d{1,2}\\b";
		Boolean isMatch = datetime.matches(reg);
		if(!isMatch) {
			throw new DatetimeFormatException("The input string is not the format: yy-mm-ss h-m-s");
		}
		
		String[] strA = datetime.split("\\D");

		this.year = strA.length > 0 ? Integer.parseInt(strA[0]) : 0;
		this.month = strA.length > 1 ? Integer.parseInt(strA[1]) : 0;
		this.day = strA.length > 2 ? Integer.parseInt(strA[2]) : 0;
		this.hour = strA.length > 3 ? Integer.parseInt(strA[3]) : 0;
		this.minute = strA.length > 4 ? Integer.parseInt(strA[4]) : 0;
		this.second = strA.length > 5 ? Integer.parseInt(strA[5]) : 0;
		
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
	
	public int Year () {
		return this.year;
	}
	public int Month () {
		return this.month;
	}
	public int Day () {
		return this.day;
	}
	public int Hour () {
		return this.hour;
	}
	public int Minute () {
		return this.minute;
	}
	public int Second () {
		return this.second;
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
	
	public Boolean isEquals (DateTime dateTime) {
		if (dateTime.Year() == this.year && 
			dateTime.Month() == this.month &&
			dateTime.Day() == this.day &&
			dateTime.Hour() == this.hour &&
			dateTime.Minute() == this.minute &&
			dateTime.Second() == this.second) 
		{
			return true;
		}
		return false;
	}
	
	public Boolean isBigger (DateTime dateTime) {
		if(dateTime.Year() > this.year) {
			return false;
		} else if (dateTime.Year() < this.year) {
			return true;
		}
		if(dateTime.Month() > this.month) {
			return false;
		} else if (dateTime.Month() < this.month) {
			return true;
		}
		if(dateTime.Day() > this.day) {
			return false;
		} else if (dateTime.Day() < this.day) {
			return true;
		}
		if(dateTime.Hour() > this.hour) {
			return false;
		} else if (dateTime.Hour() < this.hour) {
			return true;
		}
		if(dateTime.Minute() > this.minute) {
			return false;
		} else if (dateTime.Minute() < this.minute) {
			return true;
		}
		if(dateTime.Second() > this.second) {
			return false;
		} else if (dateTime.Second() < this.second) {
			return true;
		}
		return true;
	}
	
	public DateTime addYears(int years) throws DatetimeFormatException {
		int year = this.year + years;
		
		DateTime addedDateTime = new DateTime(year + "-" + this.month + "-" + this.day + " " + this.hour + ":" + this.minute + ":" + this.second);
		
		return addedDateTime;
	}
	
	public DateTime addMonths(int months) throws DatetimeFormatException {
		
		int year = this.year;
		
		int month = this.month;
		
		month += months;
		
		int addedYears = (int) month / 12;
		
		year += addedYears;
		
		month += month % 12;

		DateTime addedDateTime = new DateTime(year + "-" + month + "-" + this.day + " " + this.hour + ":" + this.minute + ":" + this.second);
		
		return addedDateTime;
	}
	
	public DateTime addWeeks(double weeks) throws DatetimeFormatException {
		
		double oriSeconds = getYoungSeconds(this);
		
		double addedSeconds = oriSeconds + weeks * 7 * 3600 * 24;
		
		DateTime addedDateTime = convertYoungSecondsToDateTime(addedSeconds);
		
		return addedDateTime;
	}
	
	public DateTime addDays(double days) throws DatetimeFormatException {
		
		double oriSeconds = getYoungSeconds(this);
		
		double addedSeconds = oriSeconds + days * 3600 * 24;
		
		DateTime addedDateTime = convertYoungSecondsToDateTime(addedSeconds);
		
		return addedDateTime;
	}
	
	public DateTime addHours(double hours) throws DatetimeFormatException {
		
		double oriSeconds = getYoungSeconds(this);
		
		double addedSeconds = oriSeconds + hours * 3600;
		
		DateTime addedDateTime = convertYoungSecondsToDateTime(addedSeconds);
		
		return addedDateTime;
	}
	
	public DateTime addMinutes(double minutes) throws DatetimeFormatException {
		
		double oriSeconds = getYoungSeconds(this);
		
		double addedSeconds = oriSeconds + minutes * 60;
		
		DateTime addedDateTime = convertYoungSecondsToDateTime(addedSeconds);
		
		return addedDateTime;
	}
	
	public DateTime addSeconds(double seconds) throws DatetimeFormatException {
		
		double oriSeconds = getYoungSeconds(this);
		
		double addedSeconds = oriSeconds + seconds;
		
		DateTime addedDateTime = convertYoungSecondsToDateTime(addedSeconds);
		
		return addedDateTime;
	}
	
	private double getYoungSeconds(DateTime dateTime) throws DatetimeFormatException{
		
		DateTime youngDateTime = new DateTime("1988-01-01 00:00:00");
		
		int gapYears = dateTime.Year() - youngDateTime.Year();
		
		int totalSeconds = gapYears * 365 * 24 * 3600;
		
		int leapYearsNum = gapYears % 4 == 0 ? (int)Math.floor(gapYears / 4) : (int)Math.floor(gapYears / 4) + 1;
		
		totalSeconds += leapYearsNum * 24 * 3600;
		
		int dayOfTheYear = dateTime.getDayOfYear();
		
		totalSeconds += (dayOfTheYear - 1) * 24 * 3600;
		
		totalSeconds += dateTime.Hour() * 3600;
		
		totalSeconds += dateTime.Minute() * 60;
		
		totalSeconds += dateTime.Second();
		
		return totalSeconds;
	}
	
	private static DateTime convertYoungSecondsToDateTime(double seconds) throws DatetimeFormatException {
		
		DateTime youngDateTime = new DateTime("1988-01-01 00:00:00");
		
		double leftSeconds = seconds;
		
		int year = youngDateTime.Year();
		
		while ((year % 4 == 0 && leftSeconds >= 366 * 3600 * 24) || (year % 4 != 0 && leftSeconds >= 365 * 3600 * 24)) {
			
			if (year % 4 == 0) {
				year++;
				leftSeconds -= 366 * 3600 * 24;
			} else {
				year++;
				leftSeconds -= 365 * 3600 * 24;
			}
		}
		
		int month = youngDateTime.Month();
		
		while (leftSeconds >= getDaysInMonth(month, year) * 3600 * 24) {
			leftSeconds -= getDaysInMonth(month, year) * 3600 * 24;
			
			month++;
		}
		
		int day = youngDateTime.Day();
		
		day += (int)(leftSeconds / (24 * 3600));
		
		leftSeconds -= ((int)(leftSeconds / (24 * 3600))) * 24 * 3600;
		
		int hour = youngDateTime.Hour();
		
		hour += (int)(leftSeconds / 3600);
		
		leftSeconds -= ((int)(leftSeconds / 3600)) * 3600 ;
		
		int minute = youngDateTime.Minute();
		
		minute += (int)(leftSeconds / 60);
		
		leftSeconds -= ((int)(leftSeconds / 60)) * 60;
		
		int second = youngDateTime.Second();
		
		second += (int)leftSeconds;
		
		return new DateTime(year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second);
	}
	
	public int getDayOfYear() {
		
		int month = this.Month();
		
		int totalDays = 0;
		
		for(int i = 1; i < month; i++) {
			totalDays += getDaysInMonth(i, this.Year());
		}
		
		totalDays += this.Day();

		return totalDays;
	}
	
	private static int getDaysInMonth(int month, int year) {
		int days = 0;
		
		Boolean isLeapYear = false;
		if (year % 4 == 0) {
			isLeapYear = true;
		}
		switch(month) {
			case 1: days = 31;
				break;
			case 2: days = isLeapYear ? 29 : 28;
				break;
			case 3: days = 31;
				break;
			case 4: days = 30;
				break;
			case 5: days = 31;
				break;
			case 6: days = 30;
				break;
			case 7: days = 31;
				break;
			case 8: days = 31;
				break;
			case 9: days = 30;
				break;
			case 10: days = 31;
				break;
			case 11: days = 30;
				break;
			case 12: days = 31;
				break;
		}
		
		return days;
	}
}

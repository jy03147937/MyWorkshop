package DBConnector;

import java.util.Date;

public class StockRelation {

	private int RecordID;
	private Date Date;
	private float TwentyMinsBeforeCloseMorning;
	private float DiffAfternoon;

	public int getRecordID() {
		return RecordID;
	}
	public void setRecordID(int recordID) {
		this.RecordID = recordID;
	}
	public Date getDate() {
		return Date;
	}
	public void setDate(Date date) {
		this.Date = date;
	}
	public float getTwentyMinsBeforeCloseMorning() {
		return TwentyMinsBeforeCloseMorning;
	}
	public void setTwentyMinsBeforeCloseMorning(float value) {
		this.TwentyMinsBeforeCloseMorning = value;
	}
	public float getDiffAfternoon() {
		return DiffAfternoon;
	}
	public void setDiffAfternoon(float value) {
		this.DiffAfternoon = value;
	}
}

package DBConnector;

import Controls.DateTime;

public class StockRelation {

	private DateTime Date;
	private float TwentyMinsBeforeCloseMorning;
	private float DiffAfternoon;

	public DateTime getDate() {
		return Date;
	}
	public void setDate(DateTime date) {
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

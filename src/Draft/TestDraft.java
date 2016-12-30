package Draft;

import java.util.Arrays;

import Controls.DateTime;
import Controls.DatetimeFormatException;

public class TestDraft {

	public static void main(String[] args) throws DatetimeFormatException {

		int[] array = {0,0};
		changeArray(array);
		System.out.println(Arrays.toString(array));
	}

	
	private static void changeArray(int[] array) throws DatetimeFormatException {
		array[0] = 1;
	}

}

package logic;

import java.time.LocalDate;
import java.time.LocalTime;

public class Helper {

	/*
	 * 
	 */
	public static String getLocalTimeDateToString() {

		int day = LocalDate.now().getDayOfMonth();
		int month = LocalDate.now().getMonthValue();
		int year = LocalDate.now().getYear();
		int second = LocalTime.now().getSecond();
		int minute = LocalTime.now().getMinute();
		int hour = LocalTime.now().getHour();

		return "Date(" + day + "/" + month + "/" + year + "),Time(" + hour + ":" + minute + ":" + second + ")";
	}

	/*
	 * 
	 */
	public static void makeUserWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

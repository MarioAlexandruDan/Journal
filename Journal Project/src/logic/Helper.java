package logic;

import java.time.LocalDate;
import java.time.LocalTime;

public class Helper {

	/**
	 * This method gets the Local Time Date of the current machine.
	 * 
	 * @return String This returns the formated String of the desired information
	 *         about the Local Time Date
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

	/**
	 * This method makes the program sleep for 1000 milliseconds.
	 * 
	 * @exception InterruptedException On Interruption error
	 * @see InterruptedException
	 */
	public static void makeUserWait() {

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class UsersMapping {

	/*
	 * This method gets the List of the current users.
	 */
	public static List<String> getUsers() {

		String[] temporaryStringVector = null;
		List<String> listOfUsers = new ArrayList<>();
		File userDatabaseFile = new File("Users");
		temporaryStringVector = userDatabaseFile.list();

		for (String User : temporaryStringVector) {
			listOfUsers.add(User);
		}
		return listOfUsers;
	}

	/*
	 * This method gets the path of the current user.
	 */
	public static Path getPath(String User) {
		Path path = Paths.get("Users\\" + User + "\\" + User + ".txt");
		return path;
	}

	/*
	 * This method gets the input from the user.
	 */
	public static String getInput() throws IOException {

		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String input = bufferReader.readLine();

		return input;

	}

	public static String getLocalTimeDateToString() {

		int day = LocalDate.now().getDayOfMonth();
		int month = LocalDate.now().getMonthValue();
		int year = LocalDate.now().getYear();
		int second = LocalTime.now().getSecond();
		int minute = LocalTime.now().getMinute();
		int hour = LocalTime.now().getHour();

		return "Date(" + day + "/" + month + "/" + year + "),Time(" + hour + ":" + minute + ":" + second + ")";
	}

	public static void makeUserWait() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

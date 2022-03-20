package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LogIn {

	/*
	 * This method is used for the greeting message and getting the User name.
	 */
	public static void startMessage() {

		System.out.println("Journal Project made by Dan Mario-Alexandru. Please enter your name bellow: " + "\n");

	}

	/*
	 * This method is used for checking if the User name exists, and does something
	 * after.
	 */
	public static void checkForUser() {

		try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in))) {
			String input = bufferReader.readLine();
			if (input != null) {
				if (UsersMapping.getUsers().contains(input)) {
					UsersLogic.chooseOptionForExistentUser(input);
				} else {
					System.out.println("Tot e bine" + input);
				}
			} else {
//				throw UserNotFoundException();
			}

		} catch (IOException e) {
			e.printStackTrace();
//			To be continued
		}

	}
}

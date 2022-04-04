package logic;

import java.io.IOException;

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
	public static void checkForUser() throws IOException {

		String input = null;
		input = UsersMapping.getInput();

		if (UsersMapping.getUsers().contains(input)) {
			UsersLogic.chooseOptionForExistentUser(input);
		} else {
			UsersLogic.createUserAndJournal(input);
			UsersLogic.chooseOptionForExistentUser(input);
		}
	}
}

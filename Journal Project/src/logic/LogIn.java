package logic;

import java.io.IOException;

public class LogIn {

	/*
	 * This method is used for checking if the User name exists, and does something
	 * after.
	 */
	public static void checkForUser() throws IOException {

		String input = null;
		input = UserIO.getInput();

		if (UserIO.getUsers().contains(input)) {
			UserLogic.chooseOptionForExistentUser(input);
		} else {
			JournalIO.createUserAndJournal(input);
			UserLogic.chooseOptionForExistentUser(input);
		}
	}
}

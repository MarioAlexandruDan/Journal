package logic;

import java.io.IOException;

import models.Messages;

public class UserLogic {

	/*
	 * This method is used for understanding what the user wants to do.
	 */
	public static void chooseOptionForExistentUser(String User) throws IOException {

		Messages.userOptionsMessage();

		String input = UserIO.getInput();

		accessOption(input, User);

	}

	/*
	 * 
	 */
	public static void accessOption(String input, String User) throws IOException {

		if (input.contains("1")) {

			JournalIO.readTheJournal(User);

		} else if (input.contains("2")) {

			changeTheJournal(User);

		} else if (input.contains("3")) {

			Messages.programClosedMessage();

		} else {

			wrongInput(User);

		}
	}

	/*
	 * 
	 */
	public static void changeTheJournal(String User) throws IOException {

		Messages.journalOptionsMessage();

		String input = UserIO.getInput();

		if (input.contains("1")) {

			JournalIO.updateTheJournal(User);

		} else if (input.contains("2")) {

			JournalIO.deleteTheJournal(User);

		} else if (input.contains("3")) {

			UserIO.deleteTheUser(User);

		} else if (input.contains("4")) {

			Messages.programClosedMessage();

		} else {

			wrongInput(User);

		}
	}

	/*
	 * 
	 */
	public static void returnToMainMenu(String User) throws IOException {

		Messages.returnToMainMenuMessage();

		Helper.makeUserWait();

		chooseOptionForExistentUser(User);
	}

	/*
	 * 
	 */
	public static void wrongInput(String User) throws IOException {

		Messages.notValidMessage();

		Helper.makeUserWait();

		chooseOptionForExistentUser(User);
	}

	/*
	 * 
	 */
	public static void doSomethingElse(String User) throws IOException {

		Messages.doSomethingElseMessage();

		String input = UserIO.getInput();

		if (input.contains("1")) {

			returnToMainMenu(User);

		} else if (input.contains("2")) {

			Messages.programClosedMessage();

		} else {

			wrongInput(User);

		}

	}

}

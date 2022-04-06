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

	public static void accessOption(String input, String User) throws IOException {

		if (input.contains("1")) {

			readTheJournal(User);

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
	public static void readTheJournal(String User) {

		JournalIO.readTheJournal(User);

	}

	public static void changeTheJournal(String User) throws IOException {

		Messages.journalOptionsMessage();

		String input = UserIO.getInput();

		if (input.contains("1")) {

			updateTheJournal(User);

		} else if (input.contains("2")) {

			deleteTheJournal(User);

		} else if (input.contains("3")) {

			deleteTheUser(User);

		} else if (input.contains("4")) {

			Messages.programClosedMessage();

		} else {

			wrongInput(User);

		}
	}

	public static void updateTheJournal(String User) throws IOException {

		Messages.areYouSureMessage();

		String input = UserIO.getInput();

		if (input.contains("1")) {

			JournalIO.readTheJournal(User);

			System.out.println("\n\n" + Helper.getLocalTimeDateToString() + ",New Entry: " + "\n");

			input = UserIO.getInput();

			JournalIO.updateTheJournal(User,
					"\n\n" + Helper.getLocalTimeDateToString() + ",New Entry: " + "\n" + input);

		} else if (input.contains("2")) {

			returnToMainMenu(User);

		} else {

			wrongInput(User);
		}

	}

	public static void deleteTheJournal(String User) throws IOException {

		Messages.areYouSureMessage();

		String input = UserIO.getInput();

		if (input.contains("1")) {

			JournalIO.deleateTheJournal(User);

		} else if (input.contains("2")) {

			returnToMainMenu(User);

		} else {

			wrongInput(User);

		}
	}

	public static void returnToMainMenu(String User) throws IOException {

		Messages.returnToMainMenuMessage();

		Helper.makeUserWait();

		chooseOptionForExistentUser(User);
	}

	public static void wrongInput(String User) throws IOException {

		Messages.notValidMessage();

		Helper.makeUserWait();

		chooseOptionForExistentUser(User);
	}

	public static void deleteTheUser(String User) throws IOException {

		Messages.areYouSureMessage();

		String input = UserIO.getInput();

		if (input.contains("1")) {

			UserIO.deleteTheUser(User);

		} else if (input.contains("2")) {

			returnToMainMenu(User);

		} else {

			wrongInput(User);

		}
	}

}

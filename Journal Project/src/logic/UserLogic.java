package logic;

import java.io.IOException;

import models.Messages;

public class UserLogic {

	// Used to know if the space in output is needed
	static boolean noSpace = false;

	/**
	 * This method checks if the User is in the local Data Base, and if he isn't the
	 * method creates the new User. This method also lets the User choose an option
	 * to make.
	 * 
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void checkForUser() throws IOException {

		String input = null;
		input = UserIO.getInput();

		if (UserIO.getUsers().contains(input)) {

			chooseOptionForUser(input);

		} else {

			JournalIO.createUserAndJournal(input);
			chooseOptionForUser(input);
		}
	}

	/**
	 * This method is used to understand the option the User wants to make.
	 * 
	 * @param user Refers to the User name
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void chooseOptionForUser(String user) throws IOException {

		if (!noSpace) {
			System.out.println();
		}
		noSpace = false;

		Messages.userOptionsMessage();

		String input = UserIO.getInput();
		accessOption(input, user);
	}

	/**
	 * This method is used to access the option the User wants to make.
	 * 
	 * @param input Refers to the User option
	 * @param user  Refers to the User name
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void accessOption(String input, String user) throws IOException {

		if (input.contains("1")) {

			System.out.println();
			JournalIO.readTheJournal(user);

		} else if (input.contains("2")) {

			System.out.println();
			changeTheJournal(user);

		} else if (input.contains("3")) {

			System.out.println();
			Messages.programClosedMessage();

		} else {

			wrongInput(user);
		}
	}

	/**
	 * This method is used to make changes to the journal.
	 * 
	 * @param user Refers to the User name
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void changeTheJournal(String user) throws IOException {

		Messages.userChangesMessage();

		String input = UserIO.getInput();

		if (input.contains("1")) {

			JournalIO.updateTheJournal(user);

		} else if (input.contains("2")) {

			JournalIO.deleteTheJournal(user);

		} else if (input.contains("3")) {

			UserIO.deleteTheUser(user);

		} else if (input.contains("4")) {

			System.out.println();
			Messages.programClosedMessage();

		} else {

			wrongInput(user);
		}
	}

	/**
	 * This method is used to return the User to the main menu.
	 * 
	 * @param user Refers to the User name
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void returnToMainMenu(String user) throws IOException {

		System.out.println();
		Messages.returnToMainMenuMessage();

		Helper.makeUserWait();

		chooseOptionForUser(user);
	}

	/**
	 * This method prints the message informing the User the input was wrong and
	 * returns him to the main menu.
	 * 
	 * @param user Refers to the User name
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void wrongInput(String user) throws IOException {

		System.out.println();
		noSpace = true;
		Messages.notValidMessage();

		Helper.makeUserWait();

		chooseOptionForUser(user);
	}

	/**
	 * This method lets the User do something else if he wishes to.
	 * 
	 * @param user Refers to the User name
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void doSomethingElse(String user) throws IOException {

		Messages.doSomethingElseMessage();
		String input = UserIO.getInput();

		if (input.contains("1")) {

			returnToMainMenu(user);

		} else if (input.contains("2")) {

			System.out.println();
			Messages.programClosedMessage();

		} else {

			wrongInput(user);
		}
	}
}

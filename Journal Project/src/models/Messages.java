package models;

public class Messages {

	/*
	 * This method is used for the greeting message and getting the User name.
	 */
	public static void startMessage() {

		System.out.println("Journal Project made by Dan Mario-Alexandru. Please enter your name bellow: " + "\n");

	}

	/*
	 * 
	 */
	public static void userOptionsMessage() {

		System.out.println("\n" + "Would you want to:" + "\n" + "1. Read the journal?" + "\n"
				+ "2. Make changes to the current journal?" + "\n" + "3. Exit." + "\n"
				+ "Please type one of the numbers above." + "\n");

	}

	/*
	 * 
	 */
	public static void journalOptionsMessage() {

		System.out.println("\n" + "Would you want to:" + "\n" + "1. Update the journal?" + "\n"
				+ "2. Delete the journal?" + "\n" + "3. Deleate the User?" + "\n" + "4. Exit." + "\n"
				+ "Please type one of the numbers above." + "\n");

	}

	/*
	 * 
	 */
	public static void areYouSureMessage() {

		System.out.println("\n" + "Are you sure?" + "\n" + "1. Yes" + "\n" + "2. No" + "\n"
				+ "Please type one of the numbers above." + "\n");
	}

	/*
	 * 
	 */
	public static void notValidMessage() {

		System.out.println("\n" + "Are you sure?" + "\n" + "1. Yes" + "\n" + "2. No" + "\n"
				+ "Please type one of the numbers above." + "\n");
	}

	/*
	 * 
	 */
	public static void returnToMainMenuMessage() {

		System.out.println("\n" + "You will be redirected to main menu");
	}

	/*
	 * 
	 */
	public static void programClosedMessage() {

		System.out.println("\n" + "Program closed!");

	}
}

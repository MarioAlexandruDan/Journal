package models;

public class Messages {

	/**
	 * This method prints the information about the creator and asks for the User
	 * name.
	 * 
	 */
	public static void startMessage() {

		System.out.println("Journal Project made by Dan Mario-Alexandru. Please enter your User name bellow: " + "\n");

	}

	/**
	 * This method prints the message for the possible options the User can make.
	 * 
	 */
	public static void userOptionsMessage() {

		System.out.println(
				"Would you want to:" + "\n" + "1. Read the journal?" + "\n" + "2. Make changes to the current journal?"
						+ "\n" + "3. Exit." + "\n" + "Please type one of the numbers above." + "\n");

	}

	/**
	 * This method prints the message for the possible changes the User can make.
	 * 
	 */
	public static void userChangesMessage() {

		System.out.println("Would you want to:" + "\n" + "1. Update the journal?" + "\n" + "2. Delete the journal?"
				+ "\n" + "3. Deleate the User?" + "\n" + "4. Exit." + "\n" + "Please type one of the numbers above."
				+ "\n");

	}

	/**
	 * This method prints a question to make sure about your decision.
	 * 
	 */
	public static void areYouSureMessage() {

		System.out.println("Are you sure?" + "\n" + "1. Yes" + "\n" + "2. No" + "\n"
				+ "Please type one of the numbers above." + "\n");
	}

	/**
	 * This method prints the message informing the User the input wasn't valid.
	 * 
	 */
	public static void notValidMessage() {

		System.out.println("Sorry, the input wasn't valid! You will be redirected to main menu." + "\n");
	}

	/**
	 * This method prints the message informing the User that he will be redirected
	 * to main menu.
	 * 
	 */
	public static void returnToMainMenuMessage() {

		System.out.println("You will be redirected to main menu.");
	}

	/**
	 * This method prints the message informing the User that the program is closed.
	 * 
	 */
	public static void programClosedMessage() {

		System.out.println("Program closed!");

	}

	/**
	 * This method prints a question to understand if the User wants to do something
	 * else.
	 * 
	 */
	public static void doSomethingElseMessage() {

		System.out.println("Would you want to do something else?" + "\n" + "1. Yes" + "\n" + "2. No" + "\n"
				+ "Please type one of the numbers above." + "\n");

	}
}

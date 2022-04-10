package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import models.Messages;

public class JournalIO {

	/**
	 * This method gets the local Data Base, creates a folder with the name of the
	 * User and inside that folder it creates a .txt file with the same name.
	 * 
	 * @param user Refers to the User name
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void createUserAndJournal(String user) {

		Path path1 = Paths.get("Users\\" + user).toAbsolutePath();
		Path path2 = UserIO.getPath(user).toAbsolutePath();
		new File(path1.toString()).mkdirs();

		try {

			new File(path2.toString()).createNewFile();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method reads the content of the .txt file inside the current User
	 * folder.
	 * 
	 * @param User Refers to the User name
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void readTheJournal(String user) throws IOException {

		Messages.areYouSureMessage();
		String input = UserIO.getInput();

		if (input.contains("1")) {

			Path path = UserIO.getPath(user).toAbsolutePath();
			System.out.println();

			try {

				byte[] bytes = Files.readAllBytes(path);
				for (byte b : bytes) {
					System.out.print((char) b);

				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("\n");
			Helper.makeUserWait();

			UserLogic.doSomethingElse(user);

		} else if (input.contains("2")) {

			UserLogic.returnToMainMenu(user);

		} else {

			UserLogic.wrongInput(user);
		}
	}

	/**
	 * This method reads the content of the .txt file inside the current User folder
	 * and appends the User input text to the same file.
	 * 
	 * @param User Refers to the User name
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void updateTheJournal(String user) throws IOException {

		System.out.println();
		Messages.areYouSureMessage();
		String input = UserIO.getInput();

		if (input.contains("1")) {

			Path path = UserIO.getPath(user).toAbsolutePath();
			String text = "";
			System.out.println();

			byte[] bytes = Files.readAllBytes(path);

			for (byte b : bytes) {

				System.out.print((char) b);
				text += (char) b;
			}

			if (!text.equals("")) {

				System.out.println("\n\n" + Helper.getLocalTimeDateToString() + ",New Entry: " + "\n");
				input = "\n\n" + Helper.getLocalTimeDateToString() + ",New Entry: " + "\n" + UserIO.getInput();

				try {

					Files.write(path, input.getBytes(), StandardOpenOption.APPEND);

				} catch (IOException e) {
					e.printStackTrace();
				}

			} else {

				System.out.println(Helper.getLocalTimeDateToString() + ",New Entry: " + "\n");
				input = Helper.getLocalTimeDateToString() + ",New Entry: " + "\n" + UserIO.getInput();

				try {

					Files.write(path, input.getBytes(), StandardOpenOption.APPEND);

				} catch (IOException e) {
					e.printStackTrace();
				}

			}

			System.out.println();

			Helper.makeUserWait();

			UserLogic.doSomethingElse(user);

		} else if (input.contains("2")) {

			UserLogic.returnToMainMenu(user);

		} else {

			UserLogic.wrongInput(user);
		}
	}

	/**
	 * This method actually recreates the .txt file.
	 * 
	 * @param User Refers to the User name
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void deleteTheJournal(String user) throws IOException {

		System.out.println();
		Messages.areYouSureMessage();
		String input = UserIO.getInput();

		if (input.contains("1")) {

			Path path = UserIO.getPath(user).toAbsolutePath();

			try (BufferedWriter writer = Files.newBufferedWriter(path)) {

				writer.write("");
				writer.flush();

			} catch (IOException e) {
				e.printStackTrace();
			}

			Helper.makeUserWait();

			UserLogic.doSomethingElse(user);

		} else if (input.contains("2")) {

			UserLogic.returnToMainMenu(user);

		} else {

			UserLogic.wrongInput(user);
		}
	}
}

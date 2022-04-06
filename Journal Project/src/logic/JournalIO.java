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

	/*
	 * 
	 */
	public static void createUserAndJournal(String User) {
		Path path1 = Paths.get("Users\\" + User).toAbsolutePath();
		Path path2 = UserIO.getPath(User).toAbsolutePath();
		new File(path1.toString()).mkdirs();
		try {
			new File(path2.toString()).createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * This method reads the text from the user
	 */
	public static void readTheJournal(String User) throws IOException {

		Messages.areYouSureMessage();

		String input = UserIO.getInput();

		if (input.contains("1")) {

			Path path = UserIO.getPath(User).toAbsolutePath();

			System.out.print("\n");

			try {
				byte[] bytes = Files.readAllBytes(path);
				for (byte b : bytes) {
					System.out.print((char) b);
				}
			} catch (IOException e) {
				e.printStackTrace();
//				To be continued
			}

			Helper.makeUserWait();

			UserLogic.doSomethingElse(User);

		} else if (input.contains("2")) {

			UserLogic.returnToMainMenu(User);

		} else {

			UserLogic.wrongInput(User);
		}

	}

	/*
	 * 
	 */
	public static void updateTheJournal(String User) throws IOException {

		Messages.areYouSureMessage();

		String input = UserIO.getInput();

		if (input.contains("1")) {

			Path path = UserIO.getPath(User).toAbsolutePath();

			System.out.print("\n");

			try {
				byte[] bytes = Files.readAllBytes(path);
				for (byte b : bytes) {
					System.out.print((char) b);
				}
			} catch (IOException e) {
				e.printStackTrace();
//				To be continued
			}

			System.out.println("\n\n" + Helper.getLocalTimeDateToString() + ",New Entry: " + "\n");

			input = "\n\n" + Helper.getLocalTimeDateToString() + ",New Entry: " + "\n" + UserIO.getInput();

			try {
				Files.write(path, input.getBytes(), StandardOpenOption.APPEND);

			} catch (IOException e) {
				e.printStackTrace();
//				To be continued
			}

			Helper.makeUserWait();

			UserLogic.doSomethingElse(User);

		} else if (input.contains("2")) {

			UserLogic.returnToMainMenu(User);

		} else {

			UserLogic.wrongInput(User);
		}
	}

	/*
	 * 
	 */
	public static void deleteTheJournal(String User) throws IOException {

		Messages.areYouSureMessage();

		String input = UserIO.getInput();

		if (input.contains("1")) {

			Path path = UserIO.getPath(User).toAbsolutePath();

			try (BufferedWriter writer = Files.newBufferedWriter(path)) {
				writer.write("");
				writer.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Helper.makeUserWait();

			UserLogic.doSomethingElse(User);

		} else if (input.contains("2")) {

			UserLogic.returnToMainMenu(User);

		} else {

			UserLogic.wrongInput(User);

		}
	}
}

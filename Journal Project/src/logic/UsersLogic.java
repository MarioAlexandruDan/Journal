package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class UsersLogic {

	/*
	 * This method is used for understanding what the user wants to do.
	 */
	public static void chooseOptionForExistentUser(String User) throws IOException {

		String input = null;

		System.out.println("\n" + "Would you want to:" + "\n" + "1. Read the journal?" + "\n"
				+ "2. Make changes to the current journal?" + "\n" + "3. Exit." + "\n"
				+ "Please type one of the numbers above." + "\n");
		input = UsersMapping.getInput();

		if (input.contains("1")) {

			readTheJournal(User);

		} else if (input.contains("2")) {

			System.out.println("\n" + "Would you want to:" + "\n" + "1. Update the journal?" + "\n"
					+ "2. Deleate the journal?" + "\n" + "3. Deleate the User?" + "\n" + "4. Exit." + "\n"
					+ "Please type one of the numbers above." + "\n");
			input = UsersMapping.getInput();

			if (input.contains("1")) {
				readTheJournal(User);

				System.out.println("\n\n" + UsersMapping.getLocalTimeDateToString() + ",New Entry: " + "\n");
				input = UsersMapping.getInput();
				updateTheJournal(User,
						"\n\n" + UsersMapping.getLocalTimeDateToString() + ",New Entry: " + "\n" + input);

			} else if (input.contains("2")) {

				System.out.println("\n" + "Are you sure?" + "\n" + "1. Yes" + "\n" + "2. No" + "\n"
						+ "Please type one of the numbers above." + "\n");
				input = UsersMapping.getInput();

				if (input.contains("1")) {

					deleateTheJournal(User);

				} else if (input.contains("2")) {

					UsersMapping.makeUserWait();
					chooseOptionForExistentUser(User);

				} else {
					System.out.println("\n" + "Please enter a valid number next time!");
					UsersMapping.makeUserWait();
					chooseOptionForExistentUser(User);
				}

			} else if (input.contains("3")) {

				System.out.println("\n" + "Are you sure?" + "\n" + "1. Yes" + "\n" + "2. No" + "\n"
						+ "Please type one of the numbers above." + "\n");
				input = UsersMapping.getInput();

				if (input.contains("1")) {

					deleteTheUser(User);

				} else if (input.contains("2")) {

					UsersMapping.makeUserWait();
					chooseOptionForExistentUser(User);
				} else {
					System.out.println("\n" + "Please enter a valid number next time!");
					UsersMapping.makeUserWait();
					chooseOptionForExistentUser(User);
				}

			} else if (input.contains("4")) {

				System.out.println("\n" + "Program closed!");

			} else {
				System.out.println("\n" + "Please enter a valid number next time!");
				UsersMapping.makeUserWait();
				chooseOptionForExistentUser(User);
			}

		} else if (input.contains("3")) {

			System.out.println("\n" + "Program closed!");

		} else {
			System.out.println("\n" + "Please enter a valid number next time!");
			UsersMapping.makeUserWait();
			chooseOptionForExistentUser(User);
		}
	}

	public static void createUserAndJournal(String User) {
		Path path1 = Paths.get("Users\\" + User).toAbsolutePath();
		Path path2 = UsersMapping.getPath(User).toAbsolutePath();
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
	public static void readTheJournal(String User) {
		System.out.print("\n");
		Path path = UsersMapping.getPath(User).toAbsolutePath();
		try {
			byte[] bytes = Files.readAllBytes(path);
			for (byte b : bytes) {
				System.out.print((char) b);
			}
		} catch (IOException e) {
			e.printStackTrace();
//			To be continued
		}
	}

	public static void updateTheJournal(String User, String newEntry) {
		Path path = UsersMapping.getPath(User).toAbsolutePath();

		try {
			Files.write(path, newEntry.getBytes(), StandardOpenOption.APPEND);

		} catch (IOException e) {
			e.printStackTrace();
//			To be continued
		}
	}

	public static void deleteTheUser(String User) {

		Path path1 = UsersMapping.getPath(User).toAbsolutePath();
		Path path2 = Paths.get("Users\\" + User).toAbsolutePath();

		try {
			Files.delete(path1);
			Files.delete(path2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleateTheJournal(String User) {
		Path path = UsersMapping.getPath(User).toAbsolutePath();

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write("");
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

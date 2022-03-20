package logic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class UsersLogic {

	/*
	 * This method is used for understanding what the user wants to do.
	 */
	public static void chooseOptionForExistentUser(String User) {

		System.out.println("\n" + "Would you want to:" + "\n" + "1. Read the journal?" + "\n"
				+ "2. Make changes to the current journal?" + "\n" + "Please type one of the numbers above." + "\n");
		try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in))) {
			String input = bufferReader.readLine();

			if (input.contains("1")) {
				readTheJournal(User);

			} else if (input.contains("2")) {
				System.out.println("\n" + "Would you want to:" + "\n" + "1. Update the journal?" + "\n"
						+ "2. Deleate the journal?" + "\n" + "3. Deleate the User?" + "\n"
						+ "Please type one of the numbers above." + "\n");
				try (BufferedReader bufferReaderChanges = new BufferedReader(new InputStreamReader(System.in))) {
					String inputChanges = bufferReader.readLine();

					if (inputChanges.contains("1")) {
						readTheJournal(User);
						System.out.println("\n\n" + "New Entry: " + "\n");
						try (BufferedReader bufferReaderNewEntry = new BufferedReader(
								new InputStreamReader(System.in))) {
							String inputNewEntry = "\n\n" + "New Entry:\n\n" + bufferReader.readLine();
							updateTheJournal(User, inputNewEntry);
						} catch (IOException e) {
							e.printStackTrace();
//							To be continued
						}

					} else if (inputChanges.contains("2")) {

					} else if (inputChanges.contains("3")) {

					} else {

					}

				} catch (IOException e) {
					e.printStackTrace();
//					To be continued
				}

			} else {

			}
		} catch (IOException e) {
			e.printStackTrace();
//			To be continued
		}
	}

	public static void createUserAndJournal() {

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

	public static void deleateTheUser(String User) {

	}

	public static void deleateTheJournal(String User) {

	}

}

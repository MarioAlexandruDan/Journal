package logic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import models.Messages;

public class UserIO {

	/**
	 * This method deletes the .txt file and the folder of the User.
	 * 
	 * @param user Refers to the User name
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void deleteTheUser(String user) throws IOException {

		System.out.println();
		Messages.areYouSureMessage();
		String input = UserIO.getInput();

		if (input.contains("1")) {

			Path path1 = getPath(user).toAbsolutePath();
			Path path2 = Paths.get("Users\\" + user).toAbsolutePath();

			try {

				Files.delete(path1);
				Files.delete(path2);

			} catch (IOException e) {
				e.printStackTrace();
			}

			Messages.programClosedMessage();

		} else if (input.contains("2")) {

			UserLogic.returnToMainMenu(user);

		} else {

			UserLogic.wrongInput(user);
		}
	}

	/**
	 * This method is used to get the input from the User.
	 * 
	 * @return String input Returns the input form the User
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static String getInput() throws IOException {

		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String input = bufferReader.readLine();

		return input;
	}

	/**
	 * This method is used to get a list of the current Users in the local Data
	 * Base.
	 * 
	 * @return String listOfUsers Returns the list of current Users in the local
	 *         Data Base
	 */
	public static List<String> getUsers() {

		String[] temporaryStringVector = null;
		List<String> listOfUsers = new ArrayList<>();
		File userDatabaseFile = new File("Users");
		temporaryStringVector = userDatabaseFile.list();

		for (String User : temporaryStringVector) {

			listOfUsers.add(User);
		}

		return listOfUsers;
	}

	/**
	 * This method is used to get the path of the .txt file of an User.
	 * 
	 * @param user Refers to the User name
	 * @return Path path Returns the path of the .txt file of an User
	 */
	public static Path getPath(String user) {

		Path path = Paths.get("Users\\" + user + "\\" + user + ".txt");

		return path;
	}

}

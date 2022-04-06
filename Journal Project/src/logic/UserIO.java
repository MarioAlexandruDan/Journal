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

public class UserIO {

	/*
	 * 
	 */
	public static void deleteTheUser(String User) {

		Path path1 = getPath(User).toAbsolutePath();
		Path path2 = Paths.get("Users\\" + User).toAbsolutePath();

		try {
			Files.delete(path1);
			Files.delete(path2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * This method gets the input from the user.
	 */
	public static String getInput() throws IOException {

		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		String input = bufferReader.readLine();

		return input;
	}

	/*
	 * This method gets the List of the current users.
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

	/*
	 * This method gets the path of the current user.
	 */
	public static Path getPath(String User) {
		Path path = Paths.get("Users\\" + User + "\\" + User + ".txt");
		return path;
	}

}

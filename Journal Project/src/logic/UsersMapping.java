package logic;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class UsersMapping {

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

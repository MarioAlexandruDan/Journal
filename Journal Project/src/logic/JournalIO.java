package logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

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
	public static void readTheJournal(String User) {
		System.out.print("\n");
		Path path = UserIO.getPath(User).toAbsolutePath();
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

	/*
	 * 
	 */
	public static void updateTheJournal(String User, String newEntry) {
		Path path = UserIO.getPath(User).toAbsolutePath();

		try {
			Files.write(path, newEntry.getBytes(), StandardOpenOption.APPEND);

		} catch (IOException e) {
			e.printStackTrace();
//			To be continued
		}
	}

	/*
	 * 
	 */
	public static void deleateTheJournal(String User) {
		Path path = UserIO.getPath(User).toAbsolutePath();

		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write("");
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

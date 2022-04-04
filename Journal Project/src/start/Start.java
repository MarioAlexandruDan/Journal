package start;

import java.io.IOException;

import logic.LogIn;

public class Start {

	public static void main(String[] args) throws IOException {

		LogIn.startMessage();
		LogIn.checkForUser();
		
	}
}

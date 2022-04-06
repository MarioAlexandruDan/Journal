package start;

import logic.LogIn;
import models.Messages;

import java.io.IOException;

public class Start {

	public static void main(String[] args) throws IOException {

		Messages.startMessage();
		LogIn.checkForUser();

	}
}

package start;

import java.io.IOException;

import logic.UserLogic;
import models.Messages;

/**
 * <h1>Journal</h1>
 * 
 * This program is designed to make use of the I/O concept in Java.
 * 
 * @author Dan Mario-Alexandru
 * @version 1.0
 * @since 10/04/2022
 */

public class Start {

	/**
	 * This is the main method that makes use of startMessage() and checkForUser()
	 * method.
	 * 
	 * @param args Unused
	 * @exception IOException On input error
	 * @see IOException
	 */
	public static void main(String[] args) throws IOException {

		Messages.startMessage();
		UserLogic.checkForUser();

	}
}

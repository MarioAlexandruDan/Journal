package models;

/*
 * This is the model for the User.
 */
public class User {

	private String userName;
	private String journal;

	public User(String userName) {
		this.userName = userName;
		this.journal = null;
	}

	public String getUserName() {
		return userName;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String journal) {
		this.journal = journal;
	}

	public void updateJournal(String newTextToAdd) {
		this.journal = this.journal + "\n New entry: \n" + newTextToAdd;
	}

	public void clearJournal() {
		this.journal = null;
	}
}

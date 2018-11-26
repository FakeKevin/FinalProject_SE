package ca.sheridancollege.beans;

public class Encrypt {

	private String rawPassword;
	private String encPassword;
	
	public Encrypt(String rawPassword) {
		this.rawPassword = rawPassword;
	}
	
	public String process() {
		return encPassword;
		
	}
}

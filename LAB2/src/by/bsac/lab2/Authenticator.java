package by.bsac.lab2;

public interface Authenticator {
	public boolean authenticateByUserName(String username, String password);
	
	public boolean authenticateByUserEmail(String email, String password);
}

package by.bsac.pz2;

public interface Authenticator {
	public boolean authenticateByUserName(String username, String password);
	
	public boolean authenticateByUserEmail(String email, String password);
}

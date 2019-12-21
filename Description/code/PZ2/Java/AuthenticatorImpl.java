package by.bsac.pz2;

public class AuthenticatorImpl implements Authenticator {
	// Інфармацыя для ўваходу ў вэб-праграму
	private String username = "Antos";
	private String password = "password";
	private String email = "antos@bsac.by";
	
	@Override
	public boolean authenticateByUserName(String username, String password) {
		if ( (getUsername().equalsIgnoreCase(username))
				&& (getPassword().equals(password)) ) {
			return true;
		}
		
		return false;
	}

	@Override
	public boolean authenticateByUserEmail(String email, String password) {
		if (getEmail().equalsIgnoreCase(email)
				&& getPassword().equals(password)) {
			return true;
		}
		
		return false;
	}

	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}

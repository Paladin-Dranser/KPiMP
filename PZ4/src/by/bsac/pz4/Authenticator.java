package by.bsac.pz4;

import by.bsac.pz4.model.Person;

public interface Authenticator {
	public Person authenticateByUserName(String username, String password);
	
	public Person authenticateByUserEmail(String email, String password);
}

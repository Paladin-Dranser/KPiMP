package by.bsac.pz3;

import by.bsac.pz3.model.Person;

public interface Authenticator {
	public Person authenticateByUserName(String username, String password);
	
	public Person authenticateByUserEmail(String email, String password);
}

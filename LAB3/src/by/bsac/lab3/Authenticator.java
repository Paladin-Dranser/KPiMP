package by.bsac.lab3;

import by.bsac.lab3.model.Person;

public interface Authenticator {
	public Person authenticateByUserName(String username, String password);
	
	public Person authenticateByUserEmail(String email, String password);
}

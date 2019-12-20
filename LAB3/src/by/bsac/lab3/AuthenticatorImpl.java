package by.bsac.lab3;

import java.util.Date;

import by.bsac.lab3.model.Person;

public class AuthenticatorImpl implements Authenticator {
	private String username = "Antos";
	private String password = "password";
	private String email = "antos@bsac.by";
	
	private Long id;
	private PersonRole role;
	private Date loginDate;
	
	private Person person;
	
	public AuthenticatorImpl() {
		person = new Person(999L, email, username, password, PersonRole.ADMIN, null);
	}
	
	@Override
	public Person authenticateByUserName(String username, String password) {
		if ( (getUsername().equalsIgnoreCase(username))
				&& (getPassword().equals(password)) ) {
			return getPerson();
		}
		
		return null;
	}

	@Override
	public Person authenticateByUserEmail(String email, String password) {
		if (getEmail().equalsIgnoreCase(email)
				&& getPassword().equals(password)) {
			return getPerson();
		}
		
		return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PersonRole getRole() {
		return role;
	}

	public void setRole(PersonRole role) {
		this.role = role;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
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

package by.bsac.pz5.builder;

public class User {
	private String firstName;
	private String lastName;
	private int age;
	private final String phone;
	private final String address;
	
	User(UserBuilder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.phone = builder.phone;
		this.address = builder.address;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		return "User: " + this.firstName +
				", " + this.lastName +
				", " + this.phone +
				", " + this.address;
	}
}

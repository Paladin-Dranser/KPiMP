package by.bsac.lab3;

public class Employee {
	private String firstname;
	private String lastname;
	private String birth;
	private String phone;
	private String city;
	private String address;
	
	public Employee(String firstname, String lastname, String birth,
			String phone, String city, String address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.birth = birth;
		this.phone = phone;
		this.city = city;
		this.address = address;
	}
	
	public String getFirstname() {
		return firstname;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}

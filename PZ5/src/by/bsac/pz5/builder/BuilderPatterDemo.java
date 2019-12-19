package by.bsac.pz5.builder;

public class BuilderPatterDemo {
	public static void main(String[] args) {
		User user1 = new UserBuilder("John", "Doe")
				.age(30)
				.phone("1234567")
				.address("Fake address 1234")
				.build();
		
		System.out.println(user1);
		
		User user2 = new UserBuilder("Ivan", "Petrov")
				.age(40)
				.phone("5655")
				.build();
		
		System.out.println(user2);
		
		User user3 = new UserBuilder("Super", "Man")
				.build();
		
		System.out.println(user3);
	}
}
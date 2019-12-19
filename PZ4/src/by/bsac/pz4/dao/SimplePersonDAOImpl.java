package by.bsac.pz4.dao;

import java.util.Set;

import by.bsac.pz4.PersonRole;
import by.bsac.pz4.model.Person;

import java.util.HashSet;

public class SimplePersonDAOImpl implements PersonDAO {
	private Set<Person> persons = new HashSet<Person>();
	private static SimplePersonDAOImpl simplePersonDAOImpl = new SimplePersonDAOImpl();
	
	private SimplePersonDAOImpl() {
		persons.add(new Person(1L, "john@john.com", "john", "john123", PersonRole.ADMIN, null));
		persons.add(new Person(2L, "peter@peter.com", "peter", "peter123", PersonRole.REGISTERED, null));
		persons.add(new Person(3L, "alex@alex.com", "alex", "alex123", PersonRole.REGISTERED, null));
	}
	
	public static SimplePersonDAOImpl getInstance() {
		return simplePersonDAOImpl;
	}
	@Override
	public Long add(Person person) {
		Long personId = -1L;
		
		try {
			persons.add(person);
			personId = person.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return personId;
	}

	@Override
	public Long save(Person person) {
		if (persons.contains(person)) {
			persons.remove(person);
		}
		
		persons.add(person);
		
		return person.getId();
	}

	@Override
	public boolean delete(Person person) {
		return persons.remove(person);
	}

	@Override
	public Person findByName(String name) {
		System.out.println("findByName -> All users =" + getAll());
		
		for (Person currentPerson : persons) {
			if (name.equals(currentPerson.getName())) {
				System.out.println("findByName -> " + currentPerson);
				return currentPerson;
			}
		}
		
		return null;
	}

	@Override
	public boolean update(Person person) {
		if (persons.contains(person)) {
			persons.remove(person);
		}
		
		return persons.add(person);
	}

	@Override
	public Person findByEmail(String email) {
		for (Person currentPerson : persons) {
			if (email.contentEquals(currentPerson.getEmail())) {
				return currentPerson;
			}
		}
		
		return null;
	}

	@Override
	public Set<Person> getAll() {
		return getPersons();
	}
	
	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
}

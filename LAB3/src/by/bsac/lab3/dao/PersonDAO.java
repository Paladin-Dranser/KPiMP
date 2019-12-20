package by.bsac.lab3.dao;

import java.util.Set;

import by.bsac.lab3.model.Person;

public interface PersonDAO {
	public Long add(Person person);
	public Long save(Person person);
	public boolean delete(Person person);
	public Person findByName(String name);
	public boolean update(Person person);
	public Person findByEmail(String email);
	public Set<Person> getAll();
}

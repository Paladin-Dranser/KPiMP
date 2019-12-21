package by.bsac.pz3.dao;

import java.util.Set;
import java.util.HashSet;

import by.bsac.pz3.model.Person;
import by.bsac.pz3.PersonRole;

public class SimplePersonDAOImpl implements PersonDAO {
	private Set<Person> persons = new HashSet<Person>();
	private static SimplePersonDAOImpl simplePersonDAOImpl = new SimplePersonDAOImpl();
	
	private SimplePersonDAOImpl() {
		// Карыстальнікі, якія могуць аўтэнтыфікавацца ў вэб-праграме
		persons.add(new Person(1L, "john@john.com", "john", "john123", PersonRole.ADMIN, null));
		persons.add(new Person(2L, "peter@peter.com", "peter", "peter123", PersonRole.REGISTERED, null));
		persons.add(new Person(3L, "alex@alex.com", "alex", "alex123", PersonRole.REGISTERED, null));
	}
	
	// Вяртае статычную пераменную, для магчымасці дабаўляць новых карыстальнікаў (рэгістрацыя)
	public static SimplePersonDAOImpl getInstance() {
		return simplePersonDAOImpl;
	}
	@Override
	// Дабаўленне новага карыстальніка
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
	// Захаванне карыстальніка
	public Long save(Person person) {
		if (persons.contains(person)) {
			persons.remove(person);
		}
		
		persons.add(person);
		
		return person.getId();
	}

	@Override
	// Выдаленне карыстальніка
	public boolean delete(Person person) {
		return persons.remove(person);
	}

	@Override
	// Пошук карыстальніка па імені
	public Person findByName(String name) {
		System.out.println("findByName -> All users =" + getAll());
		
		// Перабіраем усіх карыстальнікаў і параўноўваем іх
		// электронную пошту з дадзенай
		for (Person currentPerson : persons) {
			if (name.equals(currentPerson.getName())) {
				System.out.println("findByName -> " + currentPerson);
				// Калі знайшлі супадзенне, вяртаем карыстальніка
				return currentPerson;
			}
		}
		// калі не знайшлі супадзенне, вяртаем пустату
		return null;
	}

	@Override
	// Абнаўленне карыстальніка
	public boolean update(Person person) {
		if (persons.contains(person)) {
			persons.remove(person);
		}
		
		return persons.add(person);
	}

	@Override
	// Пошук карыстальніка па электроннай пошце
	// пошук адбываецца аналагічна findByName
	public Person findByEmail(String email) {
		for (Person currentPerson : persons) {
			if (email.contentEquals(currentPerson.getEmail())) {
				return currentPerson;
			}
		}
		
		return null;
	}

	@Override
	// Атрымаць мноства ўсіх карыстальнікаў
	public Set<Person> getAll() {
		return getPersons();
	}
	
	// Атрымаць мноства ўсіх карыстальнікаў
	public Set<Person> getPersons() {
		return persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}
}

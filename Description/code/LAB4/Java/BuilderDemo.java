package by.bsac.lab4;

// Дадзены клас змяшчае інфармацыю пра клуб
class Club {
	private String dance;
	private String music;
	private int people;

	public void setDance(String dance) {
		this.dance = dance;
	}

	public void setMusic(String music) {
		this.music = music;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	@Override
	public String toString() {
		return "Club [dance=" + dance + ", music=" + music + ", people=" + people + "]";
	}
}

// Абстрактны клас, які будуе аб'ект класа Club 
abstract class ClubBuilder {
	protected Club club;

	public Club getClub() {
		return club;
	}

	public void createClub() {
		club = new Club();
	}

	public abstract void buildDance();

	public abstract void buildMusic();

	public abstract void buildPeople();
}

// Музыкальны клуб са значэннямі па ўмаўчанню
class MusicClubBuilder extends ClubBuilder {
	public void buildMusic() {
		club.setMusic("vocal");
	}

	public void buildPeople() {
		club.setPeople(5);
	}

	public void buildDance() {
		club.setDance("");
	}
}

// Клуб, дзе ёсць і танцоры, і спевакі
class CommonClubBuilder extends ClubBuilder {
	public void buildMusic() {
		club.setMusic("vocal");
	}

	public void buildPeople() {
		club.setPeople(5);
	}

	public void buildDance() {
		club.setDance("DANCE");
	}
}

// Танцавальны клуб
class DanceClubBuilder extends ClubBuilder {
	public void buildDance() {
		club.setDance("DANCE");
	}

	public void buildPeople() {
		club.setPeople(5);
	}

	public void buildMusic() {
		club.setMusic("");
	}
}

// Клас, які вызначае, які клуб будзе пабудаваны,
// у залежнасці ад тыпу параметра
class Director {
	private ClubBuilder clubBuilder;

	public void setClubBuilder(ClubBuilder cb) {
		clubBuilder = cb;
	}

	public Club getClub() {
		return clubBuilder.getClub();
	}

	public void constructClub() {
		clubBuilder.createClub();
		clubBuilder.buildMusic();
		clubBuilder.buildDance();
		clubBuilder.buildPeople();
	}
}

public class BuilderDemo {
	public static void main(String[] args) {
		Director director = new Director();
		
		MusicClubBuilder musicClub = new MusicClubBuilder();
		DanceClubBuilder danceClub = new DanceClubBuilder();
		CommonClubBuilder commonClub = new CommonClubBuilder();
		
		director.setClubBuilder(musicClub);
		director.constructClub();

		Club club1 = director.getClub();
		
		director.setClubBuilder(danceClub);
		director.constructClub();
		
		Club club2 = director.getClub();
		
		director.setClubBuilder(commonClub);
		director.constructClub();
		
		Club club3 = director.getClub();
		
		System.out.println(club1);
		System.out.println(club2);
		System.out.println(club3);
	}
}

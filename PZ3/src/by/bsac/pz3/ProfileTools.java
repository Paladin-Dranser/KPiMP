package by.bsac.pz3;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import by.bsac.pz3.model.Person;

public class ProfileTools {
	public static String SESSION_LOGGEDIN_ATTRIBUTE_NAME = "user";
	public static String PERSON_IS_ADMIN = "isAdmin";
	public static String ALL_PERSONS_ATTRIBUTE_NAME = "users";
	
	public static SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static boolean isLoggedIn(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		return session != null
			   && session.getAttribute(SESSION_LOGGEDIN_ATTRIBUTE_NAME) != null;
	}
	
	public static boolean isAdmin(Person person) {
		boolean isAdmin = false;
		
		if (person != null) {
			switch (person.getRole()) {
			case ADMIN:
				isAdmin = true;
				break;
			default:
				isAdmin = false;
			}
		}
		
		return isAdmin;
	}
	
	public static Date generateLoginDate() {
		return new Date();
	}
}

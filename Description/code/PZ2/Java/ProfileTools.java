package by.bsac.pz2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class ProfileTools {
	public static String SESSION_LOGGEDIN_ATTRIBUTE_NAME = "user";
	public static String SESSION_LOGGEDIN_ATTRIBUTE_PASSWORD = "password";
	public static String SESSION_LOGGEDIN_ATTRIBUTE_DATA = "loginData";
	public static String SESSION_LOGGEDOUT_ATTRIBUTE_DATA = "logoutData";
	
	// Правяраем ці прайшоў аўтэнтыфікацыю карыстальнік у бягучай сесіі
	public static boolean isLoggedIn(HttpServletRequest request) {
		// Атрымліваем бягучую сесію, калі яе няма, то новую не ствараем (false)
		HttpSession session = request.getSession(false);
		
		return session != null
			   && session.getAttribute(SESSION_LOGGEDIN_ATTRIBUTE_NAME) != null;
	}
}
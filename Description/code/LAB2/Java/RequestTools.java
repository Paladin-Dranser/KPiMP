package by.bsac.lab2;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTools {
	// Павялічвае лічыльнік няверных уводаў даных
	public static void addLoginAttemptToSession(HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		// Атрымлівае колькасць няверных уводаў з параметра сесіі
		int attempts = Integer.parseInt(req.getSession().getAttribute("failedLoginAttemptsCount")
				.toString());
		// Павялічваем лічыльнік і запісвае назад у параметр сесіі
		req.getSession().setAttribute("failedLoginAttemptsCount", attempts + 1);
	}
	
	// Праверка на блакіроўку карыстальніка
	public static boolean isBlocked(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		// Калі карыстальнік не быў заблакаваны, то запісвае ў параметры сесіі
		// час блакіроўкі
		if (req.getSession().getAttribute("blockedDate") == null
				|| req.getSession().getAttribute("blockedTime") == null) {
			req.getSession().setAttribute("blockedDate", LocalDate.now());
			req.getSession().setAttribute("blockedTime", LocalTime.now());
		}
		System.out.println("isBlocked");
		// Калі значэнне лічыльніка >= 3, то вяртае True (карыстальнік заблакаваны)
		return Integer.parseInt(req.getSession().getAttribute("failedLoginAttemptsCount").toString()) >= 3 ? true : false;
	}
	
	public static void redirectToBlockedPage(HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		req.getRequestDispatcher("/blocked.jsp").forward(req, resp);
	}
}

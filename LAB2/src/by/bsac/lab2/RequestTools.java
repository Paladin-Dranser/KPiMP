package by.bsac.lab2;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestTools {
	public static void addLoginAttemptToSession(HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		int attempts = Integer.parseInt(req.getSession().getAttribute("failedLoginAttemptsCount")
				.toString());
		req.getSession().setAttribute("failedLoginAttemptsCount", attempts + 1);
	}
	
	public static boolean isBlocked(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		if (req.getSession().getAttribute("blockedDate") == null
				|| req.getSession().getAttribute("blockedTime") == null) {
			req.getSession().setAttribute("blockedDate", LocalDate.now());
			req.getSession().setAttribute("blockedTime", LocalTime.now());
		}
		System.out.println("isBlocked");
		return Integer.parseInt(req.getSession().getAttribute("failedLoginAttemptsCount").toString()) >= 3 ? true : false;
	}
	
	public static void redirectToBlockedPage(HttpServletRequest req,
			HttpServletResponse resp) throws IOException, ServletException {
		req.getRequestDispatcher("/blocked.jsp").forward(req, resp);
	}
}

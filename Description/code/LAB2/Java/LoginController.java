package by.bsac.lab2;

import java.io.IOException;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public LoginController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String authAction = request.getParameter("authAction");
		
		if (authAction.contentEquals("login")) {
			login(request, response);
		} else if (authAction.equals("logout")) {
			logout(request, response);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String authTypeParam = request.getParameter("authType");
		Authenticator authenticator = new AuthenticatorImpl();
		boolean isAuthentificated = false;
		String password = request.getParameter("psw");
		String authValue = request.getParameter("loginValue");
		
		if (authTypeParam.contentEquals("email")) {
			isAuthentificated = authenticator.authenticateByUserEmail(authValue, password);
		} else {
			isAuthentificated = authenticator.authenticateByUserName(authValue, password);
		}
	
		if (isAuthentificated) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			String loginData = dtf.format(now);  
			
			HttpSession session = request.getSession();
			
			session.setAttribute(ProfileTools.SESSION_LOGGEDIN_ATTRIBUTE_NAME, authValue);
			session.setAttribute(ProfileTools.SESSION_LOGGEDIN_ATTRIBUTE_PASSWORD, password);
			session.setAttribute(ProfileTools.SESSION_LOGGEDIN_ATTRIBUTE_DATA, loginData);
			
			// Калі аўтэнтыфікацыя прайшла паспяхова, абнуліць лічыльнік
			// і выдаліць дату блакіроўкі
			request.getSession().setAttribute("failedLoginAttemptsCount", 0);
			request.getSession().removeAttribute("blockedDate");
			request.getSession().removeAttribute("blockedTime");
			response.sendRedirect("home.jsp");
		} else {
			// калі аўтэнтыфікацыя правалілася,
			// павялічыць лічыльнік
			RequestTools.addLoginAttemptToSession(request, response);
			
			// калі карыстальнік заблакаваны (увёў няправільна 3 раз),
			// перанакіраваць на старонку блакіроўкі
			if (RequestTools.isBlocked(request, response)) {
				RequestTools.redirectToBlockedPage(request, response);
			} else {
				response.sendRedirect("error-login.jsp");
			}
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			String logoutData = dtf.format(now);
			
			session.setAttribute(ProfileTools.SESSION_LOGGEDOUT_ATTRIBUTE_DATA, logoutData);
			
			session.invalidate();
		}
		
		response.sendRedirect("login.jsp");
	}
}
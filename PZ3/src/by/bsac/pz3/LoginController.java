package by.bsac.pz3;

import java.io.IOException;

import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.bsac.pz3.dao.PersonDAO;
import by.bsac.pz3.dao.SimplePersonDAOImpl;
import by.bsac.pz3.model.Person;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonDAO personDAO = SimplePersonDAOImpl.getInstance();
	
	public LoginController() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		System.out.println("Login -> DoPost");
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
		Authenticator authenticator = new SimpleAuthenticatorImpl();
		Person person;
		String password = request.getParameter("psw");
		String authValue = request.getParameter("loginValue");
		
		if (authTypeParam.contentEquals("email")) {
			person = authenticator.authenticateByUserEmail(authValue, password);
		} else {
			person = authenticator.authenticateByUserName(authValue, password);
		}
	
		if (person != null) {			
			HttpSession session = request.getSession();
			
			person.setLoginDate(ProfileTools.generateLoginDate());
			getPersonDAO().save(person);
			
			session.setAttribute(ProfileTools.SESSION_LOGGEDIN_ATTRIBUTE_NAME, person.getName());
			
			if (ProfileTools.isAdmin(person)) {
				session.setAttribute(ProfileTools.PERSON_IS_ADMIN, true);
				session.setAttribute(ProfileTools.ALL_PERSONS_ATTRIBUTE_NAME, getPersonDAO().getAll());
			}
			response.sendRedirect("home.jsp");
		} else {
			response.sendRedirect("error-login.jsp");
		}
	}
	
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	public PersonDAO getPersonDAO() {
		return personDAO;
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			session.invalidate();
		}
		
		response.sendRedirect("login.jsp");
	}
}
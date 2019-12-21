package by.bsac.pz2;

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
	
	// Па запыту GET вяртаем карыстальніку старонку login.jsp
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		response.sendRedirect("login.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// Атрымліваем параметр authAction з POST запыту
		String authAction = request.getParameter("authAction");
		
		// У залежнасці ад параметра authAction вызначаем,
		// якое дзеянне выконвае карыстальнік
		if (authAction.contentEquals("login")) {
			login(request, response);
		} else if (authAction.equals("logout")) {
			logout(request, response);
		}
	}
	
	private void login(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		// Атрымліваем тып аўтэнтыфікацыі з <input type=radio> элемента
		String authTypeParam = request.getParameter("authType");
		
		Authenticator authenticator = new AuthenticatorImpl();
		boolean isAuthentificated = false;
		
		// Атрымліваем параметры, перададзеныя ў POST запыце
		String password = request.getParameter("psw");
		String authValue = request.getParameter("loginValue");
		
		if (authTypeParam.contentEquals("email")) {
			isAuthentificated = authenticator.authenticateByUserEmail(authValue, password);
		} else {
			isAuthentificated = authenticator.authenticateByUserName(authValue, password);
		}
	
		// Калі аўтэнтыфікацыя прайшла паспяхова
		if (isAuthentificated) {
			// Атрымліваем бягучую дату ў фармаце String
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			String loginData = dtf.format(now);  
			
			// Атрымліваем бягучую сесію з карыстальнікам
			HttpSession session = request.getSession();
			
			// Запісваем ў атрыманую сесію атрыбуты
			// SESSION\_LOGGEDIN\_ATTRIBUTE\_NAME неабходны, каб вызначаць ці прайшоў
			// карыстальнік аўтэнтыфікацыю
			session.setAttribute(ProfileTools.SESSION_LOGGEDIN_ATTRIBUTE_NAME, authValue);
			session.setAttribute(ProfileTools.SESSION_LOGGEDIN_ATTRIBUTE_PASSWORD, password);
			session.setAttribute(ProfileTools.SESSION_LOGGEDIN_ATTRIBUTE_DATA, loginData);
			response.sendRedirect("home.jsp");
		// Калі аўтэнтыфікацыя няверная, вяртаем старонку з памылкай
		} else {
			response.sendRedirect("error-login.jsp");
		}
	}
	
	private void logout(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		if (session != null) {
			// Атрымліваем бягучую дату ў фармаце String
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();  
			String logoutData = dtf.format(now);
			
			// Запісваем час выхаду з вэб-праграмы
			session.setAttribute(ProfileTools.SESSION_LOGGEDOUT_ATTRIBUTE_DATA, logoutData);
			
			// Выдаляем сувязь паміж аб'ектамі і дадзенай сесіяй
			session.invalidate();
		}
		
		response.sendRedirect("login.jsp");
	}
}

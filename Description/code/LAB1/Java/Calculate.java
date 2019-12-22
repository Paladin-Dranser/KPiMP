package by.bsac.lab1;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Calculate() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("lab1.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Забіраем значэнні параметраў з POST запыту
		String option = request.getParameter("triga");
		int number = Integer.parseInt(request.getParameter("calculate"));
		
		double result1;
		double result2;
		// Выконваем абраную аперацыю
		if (option.equalsIgnoreCase("cos")) {
			result1 = Math.cos(number);
			result2 = Math.cos(Math.toRadians(number));
		} else {
			result1 = Math.sin(number);
			result2 = Math.sin(Math.toRadians(number));
		}
		
		HttpSession session = request.getSession(false);

		// Запісваем вынікі ў атрыбуты сесіі
        session.setAttribute("result1", result1);
        session.setAttribute("result2", result2);
        // Вяртаем старонку з вынікам
        response.sendRedirect("result2.jsp");
	}
}

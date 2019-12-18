package by.bsac.pz1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ThirdTask")
public class ThirdTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThirdTask() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// create special input (hidden) with value which keep counter
		response.getWriter().append("<html><meta charset=UTF-8><form action=ThirdTask method=POST>1"
				+ "<input type=hidden name=P3 value=1><input type=submit></form></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get parameter (P3) and add 1
		int number = Integer.parseInt(request.getParameter("P3")) + 1;
		// return page where 'number' is changed
		response.getWriter().append("<html><meta charset=UTF-8><form action=ThirdTask method=POST>"
				+ number + "<input type=hidden name=P3 value=" + number + "><input type=submit></form></html>");
	}

}
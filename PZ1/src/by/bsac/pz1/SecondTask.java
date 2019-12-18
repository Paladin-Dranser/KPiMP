package by.bsac.pz1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondTask")
public class SecondTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondTask() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Add form tag to use POST method
		// get input name (P1) to get parameters in doPost()
		response.getWriter().append("<html><meta charset=UTF-8><form action=SecondTask method=POST>"
			+ "<label>Input box: <input type=text name=P1 value=></label><input type=submit>"
			+ "</form></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// get P1 parameter from URL
		String textOfBox = request.getParameter("P1");
		// add new value for input (P1)
		response.getWriter().append("<html><meta charset=UTF-8><form action=SecondTask method=POST>"
			+ "<label>Input box: <input type=text name=P1 value=" + textOfBox + textOfBox + ">"
			+ "</label><input type=submit></form></html>");
	}
}
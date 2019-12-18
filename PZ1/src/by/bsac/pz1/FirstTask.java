package by.bsac.pz1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstTask")
public class FirstTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FirstTask() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// html-page which is got
		response.getWriter().append("<html><meta charset=UTF-8><label>Input box:"
				+ "<input type=text name=P1></label></html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}
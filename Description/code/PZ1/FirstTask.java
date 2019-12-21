package by.bsac.pz1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// WebServlet анатацыя (замест таго, каб апісваць servlet у web.xml файле)
// Спосаб з апісаннем web.xml будзе разглядацца на наступных практычных занятках
// паказвае на якім URL-адрасе будзе выконвацца клас FirstTask
@WebServlet("/FirstTask")
public class FirstTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	// Канструктар класа, які выклікае канструктар класа HttpServlet
    public FirstTask() {
        super();
    }

    // Метад doGet выконваецца, калі на старонку сервлета адпраўляецца HTTP запыт GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Вяртаем HTML-старонку згодна з заданнем
		// <label> - тэг, адказвае за надпіс перад тэгам <input>
		// <input> - тэг, для ўводу даных, дзе
		// type=text - апісвае, што поле мае тэкставы тып
		// name=P1 - вызначаем імя адпаведна заданню.
		response.getWriter().append(
				"<html>"
				+ "<meta charset=UTF-8>"
					+ "<label>Input box:"
						+ "<input type=text name=P1>"
					+ "</label>"
				+ "</html>");
	}
}

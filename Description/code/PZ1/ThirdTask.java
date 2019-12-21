package by.bsac.pz1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//WebServlet анатацыя (замест таго, каб апісваць servlet у web.xml файле)
//Спосаб з апісаннем web.xml будзе разглядацца на наступных практычных занятках
//паказвае на якім URL-адрасе будзе выконвацца клас ThirdTask
@WebServlet("/ThirdTask")
public class ThirdTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	// Канструктар класа, які выклікае канструктар класа HttpServlet
    public ThirdTask() {
        super();
    }

    // Метад doGet выконваецца, калі на старонку сервлета адпраўляецца HTTP запыт GET
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HTML-старонка, якая вяртаецца па запыту GET
		// <input type=hidden> - схаванае поле ўводу, якое захоўвае лік (пачатковае значэнне - 1)
		response.getWriter().append(
			"<html>"
			+ "<meta charset=UTF-8>"
				+ "<form action=ThirdTask method=POST>"
					+ "1"
					+ "<input type=hidden name=P3 value=1>"
					+ "<input type=submit>"
					+ "</form>"
			+ "</html>");
	}
	
	// Метад doPost выконваецца, калі на старонку сервлета адпраўляецца HTTP запыт POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Атрымліваем параметр P3 і павялічваем яго на 1
		int number = Integer.parseInt(request.getParameter("P3")) + 1;
		// HTML-старонка, якая вяртаецца па запыту POST
		// Старонка аналагічная першапачатковай, за выключэннем таго, што
		// пачатковае значэнне 1 было замененае на новае number як
		// для тэксту, так і для <input type=hidden>
		response.getWriter().append(
			"<html>"
				+ "<meta charset=UTF-8>"
				+ "<form action=ThirdTask method=POST>"
					+ number
					+ "<input type=hidden name=P3 value=" + number + ">"
					+ "<input type=submit>"
				+ "</form>"
			+ "</html>");
	}
}
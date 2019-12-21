package by.bsac.pz1;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//WebServlet анатацыя (замест таго, каб апісваць servlet у web.xml файле)
//Спосаб з апісаннем web.xml будзе разглядацца на наступных практычных занятках
//паказвае на якім URL-адрасе будзе выконвацца клас SecondTask
@WebServlet("/SecondTask")
public class SecondTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	// Канструктар класа, які выклікае канструктар класа HttpServlet
    public SecondTask() {
        super();
    }

    // Метад doGet выконваецца, калі на старонку сервлета адпраўляецца HTTP запыт GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Вяртаем HTML-старонку згодна з заданнем
		// <label> - тэг, адказвае за надпіс перад тэгам <input>
		// <input> - тэг, для ўводу даных, дзе
		// type=text (type=submit) - апісвае, што поле мае тэкставы тып (выгляд кнопкі)
		// name=P1 - вызначаем імя адпаведна заданню.
    	// <form> - тэг, якім задаем, што:
    	// method=POST - даныя, атрыманыя ўнутры тэга form, будуць перададзены, як
    	// параметры POST запыту
    	// action - на які URL-адрас, будзе адпраўлены POST запыт
		response.getWriter().append(
			"<html>"
			+ "<meta charset=UTF-8>"
				+ "<form action=SecondTask method=POST>"
					+ "<label>Input box:"
					+ "<input type=text name=P1 value=>"
					+ "</label>"
					+ "<input type=submit>"
				+ "</form>"
			+ "</html>");
	}

    // Метад doPost выконваецца, калі на старонку сервлета адпраўляецца HTTP запыт POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Атрымліваем з запыту параметр P1 (глядзі метад doGet)
		String textOfBox = request.getParameter("P1");
		// Вяртаем HTML-старонку, згодна заданню
		// Старонка аналагічна першапачатковай (глядзі метад doGet),
		// за выключэннем таго, што для поля ўвода P1 задаецца значэнне (value),
		// роўнае параметру P1, паўторанае 2 разы.
		response.getWriter().append(
			"<html>"
			+ "<meta charset=UTF-8>"
				+ "<form action=SecondTask method=POST>"
					+ "<label>Input box:"
					+ "<input type=text name=P1 value=" + textOfBox + textOfBox + ">"
					+ "</label>"
					+ "<input type=submit>"
				+ "</form>"
			+ "</html>");
	}
}

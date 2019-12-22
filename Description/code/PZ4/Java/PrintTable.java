package by.bsac.pz4.customtags;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import by.bsac.pz4.ProfileTools;
import by.bsac.pz4.model.Person;

@SuppressWarnings("serial")
public class PrintTable extends TagSupport {
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
        HttpSession session = request.getSession();

        // Атрымлівае з параметраў сесіі інфармацыю пра карыстальнікаў
        Set<Person> users = (Set<Person>) session.getAttribute(ProfileTools.ALL_PERSONS_ATTRIBUTE_NAME);
		
		try {
			// Пачынаем html-табліцу
			StringBuilder table = new StringBuilder().append("<table width=\"100%\" border=\"1\">");
			// Дабаўляем загалоўкі для табліцы
			table.append(
				"<tr>\n"
					+ "<th>Name</th>\n"
					+ "<th>Email</th>\n"
					+ "<th>Role</th>\n"
					+ "<th>Last login date</th>\n"
				+ "</tr>");
		

			DateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
			
			// Перабіраем усіх карыстальнікаў, спіс каторых атрымалі з параметраў сесіі
			for (Person user : users) {
				Date loginDate = user.getLoginDate();
				
				// Калі карыстальнік не ўваходзіў у вэб-праграму
				// выводзіць паведамленне User have not logined у поле для даты ўваходу
				String strDate = "User have not logined";
				// Калі карыстальнік уваходзіў,
				// запісваем бягучую дату
				if (loginDate != null) {
					strDate = formatter.format(loginDate);
				}
				
				// Ствараем радок ў табліцы для бягучага карыстальніка
				table.append(
					"<tr>" +
						"<td>" + user.getName() + "</td>" +
						"<td>" + user.getEmail() + "</td>" +
			     		"<td>" + user.getRole() + "</td>" +
			    		"<td>" + strDate + "</td>" +
					"</tr>"
				);
			}
			
			// Завяршаем табліцу
			table.append("</table>");
			
			// Выводзім атрыманую табліцу замест выкліку тэга ў allUsers.jsp
			out.print(table.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
}

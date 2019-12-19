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

        Set<Person> users = (Set<Person>) session.getAttribute(ProfileTools.ALL_PERSONS_ATTRIBUTE_NAME);
		
		try {
			StringBuilder table = new StringBuilder().append("<table width=\"100%\" border=\"1\">");
			
			table.append("<tr>\n" + 
					"				<th>Name</th>\n" + 
					"				<th>Email</th>\n" + 
					"				<th>Role</th>\n" + 
					"				<th>Last login date</th>\n" + 
					"			</tr>");
		

			DateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");  
			for (Person user : users) {
				Date loginDate = user.getLoginDate();
				
				String strDate = "User have not logined";
				if (loginDate != null) {
					strDate = formatter.format(loginDate);
				}
				
				table.append("<tr>" +
						"<td>" + user.getName() + "</td>" +
						"<td>" + user.getEmail() + "</td>" +
			     		"<td>" + user.getRole() + "</td>" +
			    		"<td>" + strDate + "</td>" +
						"</tr>"
				);
			}
			
			table.append("</table>");
			out.print(table.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
}

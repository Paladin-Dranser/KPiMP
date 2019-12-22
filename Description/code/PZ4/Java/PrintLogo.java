package by.bsac.pz4.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

// Дадзены клас будзе выконвацца ў месцы, дзе будзе выклікацца
// карыстальніцкі тэг
@SuppressWarnings("serial")
public class PrintLogo extends TagSupport {
	public static final String ADMIN_IMAGE = "admin";
	public static final String USER_IMAGE = "user";
	public static final String IMAGE_PATH = "images/";
	public static final String IMAGE_EXTENSION = ".png";
	
	private boolean isAdmin;
	
	// Дадзены метад стварае поўны шлях да карцінкі лагатыпа і
	// выводзіць атрыманы шлях замест выкліку тэга ў JSP старонцы
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		
		try {
			StringBuilder fullImagePath = new StringBuilder().append(IMAGE_PATH);
			
			// У залежнасці ад ролі карыстальніка дабаўляем адпаведную карцінку
			if (isAdmin) {
				fullImagePath.append(ADMIN_IMAGE);
			} else {
				fullImagePath.append(USER_IMAGE);
			}
			
			fullImagePath.append(IMAGE_EXTENSION);
			
			// вяртаем шлях на месца выкліку тэга
			out.print(fullImagePath.toString());
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	
	public void setIsAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}

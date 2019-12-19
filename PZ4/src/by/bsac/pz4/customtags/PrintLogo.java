package by.bsac.pz4.customtags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class PrintLogo extends TagSupport {
	public static final String ADMIN_IMAGE = "admin";
	public static final String USER_IMAGE = "user";
	public static final String IMAGE_PATH = "images/";
	public static final String IMAGE_EXTENSION = ".png";
	
	private boolean isAdmin;
	
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		
		try {
			StringBuilder fullImagePath = new StringBuilder().append(IMAGE_PATH);
			
			if (isAdmin) {
				fullImagePath.append(ADMIN_IMAGE);
			} else {
				fullImagePath.append(USER_IMAGE);
			}
			
			fullImagePath.append(IMAGE_EXTENSION);
			
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

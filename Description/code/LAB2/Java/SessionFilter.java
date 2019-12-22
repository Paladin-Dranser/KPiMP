package by.bsac.lab2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsac.lab2.ProfileTools;

public class SessionFilter implements Filter {
	private ArrayList<String> ignoredUrlList;

    public SessionFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		// Калі ў сесіі няма параметра failedLoginAttemptsCount,
		// стварыць яго і прызначыць значэнне 0
		if (req.getSession().getAttribute("failedLoginAttemptsCount") == null) {
			req.getSession().setAttribute("failedLoginAttemptsCount", 0);
		}
		
		String requestUri = req.getRequestURI();
		boolean shouldBeIgnored  = isIgnoredUrl(requestUri);
		
		// Праверыць ці заблакаваны карыстальнік у дадзенай сесіі
		// калі заблакаваны, то перанакіраваць на старонку блакіроўкі,
		// інакш на старонку для ўваходу
		if (RequestTools.isBlocked(req, res)) {
			RequestTools.redirectToBlockedPage(req, res);
		} else if (!shouldBeIgnored && !ProfileTools.isLoggedIn(req)) {
			req.getRequestDispatcher("/login").forward(req, res);
		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		ignoredUrlList = new ArrayList<String>();
		String urls = fConfig.getInitParameter("ignore-urls");
		StringTokenizer token = new StringTokenizer(urls, ",");
		
		while (token.hasMoreTokens()) {
			ignoredUrlList.add(token.nextToken());
		}
	}
	
	private boolean isIgnoredUrl(String url) {
		for (String ignoredUrl : getIgnoredUrlList()) {
			if (url.startsWith(ignoredUrl)) {
				return true;
			}
		}
		
		return false;
	}
	
	public ArrayList<String> getIgnoredUrlList() {
		return ignoredUrlList;
	}
	
	public void setIgnoredUrlList(ArrayList<String> urlList) {
		this.ignoredUrlList = urlList;
	}
}
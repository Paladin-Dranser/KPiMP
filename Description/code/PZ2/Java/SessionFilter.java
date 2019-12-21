package by.bsac.pz2;

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

import by.bsac.pz2.ProfileTools;

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
		
		// Атрымліваем бягучы URL
		String requestUri = req.getRequestURI();
		// Правяраем ці з'яўляецца бягучы URL, які неабходна ігнараваць
		boolean shouldBeIgnored = isIgnoredUrl(requestUri);
		
		// Калі карыстальнік не прайшоў аўтэнтыфікацыю і URL не ігнаруецца,
		// адправіць карыстальніка на login.jsp
		if (!shouldBeIgnored && !ProfileTools.isLoggedIn(req)) {
			res.sendRedirect("login.jsp");
		} else {
			chain.doFilter(request, response);	
		}
	}

	// метад, які выноваецца перад тым, як будзе прымяняцца фільтр
	public void init(FilterConfig fConfig) throws ServletException {
		ignoredUrlList = new ArrayList<String>();
		
		// Чытаем з web.xml параметр (init-param) з імененм ignore-urls
		String urls = fConfig.getInitParameter("ignore-urls");
		
		// Дабаўляем у ignoredUrlList спіс URL-аў, атрыманых з web.xml
		StringTokenizer token = new StringTokenizer(urls, ",");
		while (token.hasMoreTokens()) {
			ignoredUrlList.add(token.nextToken());
		}
	}
	
	
	// правяраем ці з'яўляецца url тым, які дадзены фільтр мае ігнараваць
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
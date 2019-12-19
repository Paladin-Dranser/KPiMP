package by.bsac.lab2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner; 

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchWords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchWords() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String searchWords = request.getParameter("search");
		List<String> inputWords = new ArrayList<String>(Arrays.asList(searchWords.split(" ")));

		
		File file = new File("/home/dranser/Documents/BSAC/3 year/КПіМП/KPiMP/PZ2/pz2.txt");
		Scanner sc = new Scanner(file);
		String str = "";
		while (sc.hasNextLine()) {
		      str += sc.nextLine() + " "; 
		}
	
		List<String> words = new ArrayList<String>(Arrays.asList(str.split(" ")));
		
		for (String inputWord : inputWords) {
			int count = 0;
			
			for (String word : words) {
				if (word.equalsIgnoreCase(inputWord)) {
					count++;
				}
			}
			
			Cookie cookie = new Cookie(inputWord, String.valueOf(count));
			response.addCookie(cookie);
		}
		
		response.sendRedirect("home.jsp");
	}
}

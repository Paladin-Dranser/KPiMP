package by.bsac.pz2;

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
		
		// Атрымліваем спіс слоў з параметра POST запыту
		String searchWords = request.getParameter("search");
		// Падзяляем спіс слоў на асобныя словы і заносім іх у List
		List<String> inputWords = new ArrayList<String>(Arrays.asList(searchWords.split(" ")));

		// Чытаем словы з файла pz2.txt і запісваем ў str
		File file = new File("/home/dranser/Documents/BSAC/3 year/КПіМП/KPiMP/PZ2/pz2.txt");
		Scanner sc = new Scanner(file);
		String str = "";
		while (sc.hasNextLine()) {
		      str += sc.nextLine() + " "; 
		}
	
		// Падзяляем str на асобныя словы і запісваем у List
		List<String> words = new ArrayList<String>(Arrays.asList(str.split(" ")));
		
		// Перабіраем усе ўведзеныя словы
		for (String inputWord : inputWords) {
			// лічыльнік паўтораў бягучага слова
			int count = 0;
			
			// Правяраем на супадзенне ўведзенага слова з кожным словам з файла
			for (String word : words) {
				// калі словы супадаюць, павялічваем лічыльнік
				if (word.equalsIgnoreCase(inputWord)) {
					count++;
				}
			}
			
			// Запісваем у кукі браўзера словы і колькасць яго паўтарэнняў
			Cookie cookie = new Cookie(inputWord, String.valueOf(count));
			response.addCookie(cookie);
		}
		
		// вяртаем карыстальніка на старонку home
		response.sendRedirect("home.jsp");
	}
}

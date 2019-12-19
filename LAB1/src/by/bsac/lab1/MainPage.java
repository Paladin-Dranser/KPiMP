package by.bsac.lab1;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SELECT_BY_NAME = "SELECT firstname, secondname, salary FROM employee " +
            "WHERE secondname = ?";
	private static final String SELECT_ALL = "SELECT firstname, secondname, salary FROM employee";
	
	public MainPage() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("main.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Employee> employees = new ArrayList<>();
		String searchName = request.getParameter("search");
		
		Connection connection = ConnectionPool.getConnection();

        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        
        try {
        	
        	if (searchName != "") {
        		preparedStatement = connection.prepareStatement(SELECT_BY_NAME);
        		preparedStatement.setString(1, searchName);
        	} else {
        		preparedStatement = connection.prepareStatement(SELECT_ALL);
        	}
            preparedStatement.execute();
            result = preparedStatement.getResultSet();

            while (result.next()) {
                employees.add(new Employee(result.getString(1), result.getString(2), result.getInt(3)));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                result.close();
            } catch (Exception rse) {
                System.out.println(rse.getMessage());
            }
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println(sse.getMessage());
            }

            ConnectionPool.closeConnection();
        }
        HttpSession session = request.getSession(false);
     
        session.setAttribute("employees", employees);
        response.sendRedirect("result.jsp");
    }
}

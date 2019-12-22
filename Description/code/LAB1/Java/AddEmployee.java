package by.bsac.lab1;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// SQL запыт для дабаўлення запісу ў базу даных
	private static final String ADD_EMPLOYEE = "INSERT INTO kpimp.employee (firstname, secondname, salary) VALUES (?, ?, ?)";
	
	public AddEmployee() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("add.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Атрымліваем параметры з запыту POST
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		int salary = Integer.parseInt(request.getParameter("salary"));
		
		// Падключаемся да базы даных
		Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        
        try {
        	// Запаўняем SQL запыт
        	preparedStatement = connection.prepareStatement(ADD_EMPLOYEE);
        	// Замест "?" ставім неабходныя значэнні
        	preparedStatement.setString(1, firstName);
        	preparedStatement.setString(2, lastName);
        	preparedStatement.setInt(3, salary);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
            	// Завяршаем запыт
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println(sse.getMessage());
            }
            // Закрываем падключэнне
            ConnectionPool.closeConnection();
        }
        // Вяртаем галоўную старонку
        response.sendRedirect("main.jsp");
    }
}
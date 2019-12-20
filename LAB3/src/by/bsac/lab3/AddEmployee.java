package by.bsac.lab3;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String ADD_EMPLOYEE = "INSERT INTO kpimp.lab3user (firstname, lastname, birth, phone, city, address) VALUES (?, ?, ?, ?, ?, ?)";
	
	public AddEmployee() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.sendRedirect("add.jsp");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String birth = request.getParameter("birth");
		String phone = request.getParameter("phone");
		String city = request.getParameter("city");
		String address = request.getParameter("address");
		
		Connection connection = ConnectionPool.getConnection();
        PreparedStatement preparedStatement = null;
        
        boolean registration = false;
        try {
        	preparedStatement = connection.prepareStatement(ADD_EMPLOYEE);
        	preparedStatement.setString(1, firstName);
        	preparedStatement.setString(2, lastName);
        	preparedStatement.setString(3, birth);
        	preparedStatement.setString(4, phone);
        	preparedStatement.setString(5, city);
        	preparedStatement.setString(6, address);
            preparedStatement.executeUpdate();
            registration = true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            registration = false;
        } finally {
            try {
                preparedStatement.close();
            } catch (Exception sse) {
                System.out.println(sse.getMessage());
            }

            ConnectionPool.closeConnection();
        }

        HttpSession session = request.getSession(false);
        
        session.setAttribute("registrationDate", java.time.LocalDateTime.now());
        session.setAttribute("registration", registration);
        response.sendRedirect("result.jsp");
    }
}
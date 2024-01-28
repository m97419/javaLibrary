package registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

import registration.dao.UserDao;
import registration.model.User;
/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		User user=new User();
		try {
			user = userDao.login(userName, password);
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("userDetails", user);
		RequestDispatcher requestDispatcher;
		if(user == null) {
			
		}
		if(user.getStatus()==0) {
			requestDispatcher = request.getRequestDispatcher("../../WorkerHomePage.jsp");
		}
		else {
			requestDispatcher = request.getRequestDispatcher("../../UserHomePage.jsp");
		}
		if(requestDispatcher !=null )
            requestDispatcher.forward(request, response);
	}

}

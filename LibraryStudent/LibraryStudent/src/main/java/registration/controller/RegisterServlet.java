package registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import registration.dao.UserDao;
import registration.model.User;

import java.io.IOException;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String phoneNum = request.getParameter("phone");
		int status = (int)(request.getParameter("status").charAt(0)) -48;
		
		User user = new User();
		
		user.setUserName(userName);
		user.setPassword(password);
		user.setAddress(address);
		user.setPhoneNum(phoneNum);
		user.setStatus(status);
			
		try {	
			userDao.registerUser(user);
		} 
		catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/LibraryStudent/Registration.jsp");
		System.out.println("LoginSucess path->"+ requestDispatcher);
		if(requestDispatcher !=null )
            requestDispatcher.forward(request, response);
	}

}

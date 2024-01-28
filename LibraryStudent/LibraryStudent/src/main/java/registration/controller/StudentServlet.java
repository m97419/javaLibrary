package registration.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import registration.dao.UserDao;
import registration.model.User;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
//	static Logger logger = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
//    public StudentServlet() {
//    	String path = System.getProperty("user.home")+
//    			"/eclipse-workspace/Log4j_withConfFile/src/main/webapp/WEB-INF/classes/log4j.properties";
//    	   System.out.println("path->"+path);
//    		PropertyConfigurator.configure(path);
//    		logger= Logger.getLogger(StudentServlet.class.getName());
//    }

    
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
		String status = request.getParameter("status");
		
		User user = new User();
		
		user.setUserName(userName);
		user.setPassword(password);
		user.setAddress(address);
		user.setPhoneNum(status);
			
		try {
				
			userDao.registerUser(user);
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("../../http://localhost:8050/LibraryStudent/WorkerHomePage.jsp");
		System.out.println("LoginSucess path->"+ requestDispatcher);
		if(requestDispatcher !=null )
            requestDispatcher.forward(request, response);
	}

}

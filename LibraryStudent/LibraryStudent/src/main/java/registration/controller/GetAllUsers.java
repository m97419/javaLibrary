package registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import registration.dao.UserDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class GetAllUsers
 */
public class GetAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private UserDao userDao = new UserDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetAllUsers() {
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
		List dataList = new ArrayList();
		try {
			dataList = userDao.getAllUsers();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("usersData", dataList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("UsersManage.jsp");
		if(requestDispatcher !=null )
            requestDispatcher.forward(request, response);
	}

}

package registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import registration.dao.MessageDao;
import registration.dao.UserDao;
import registration.model.Message;
import registration.model.User;

import java.io.IOException;

/**
 * Servlet implementation class AddMessageServlet
 */
public class AddMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageDao messageDao = new MessageDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMessageServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String body = request.getParameter("txt");
		System.out.println("------"+request.getParameter("userId"));
		int userId = Integer.parseInt(request.getParameter("userId"));
		
		Message message = new Message();
		
		message.setBody(body);
		message.setUserId(userId);
		
		try {	
			messageDao.addMessage(message);
		} 
		catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("AddMessage.jsp");
		if(requestDispatcher !=null )
            requestDispatcher.forward(request, response);
	}

}

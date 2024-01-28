package registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import registration.dao.MessageDao;
import registration.dao.UserDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class MessagesServlet
 */
public class MessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MessageDao messageDao = new MessageDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MessageServlet() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List dataList = new ArrayList();
		try {
			dataList = messageDao.getListOfMessages();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("messageData", dataList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Messages.jsp");
		System.out.println("LoginSucess path->"+ requestDispatcher);
		if(requestDispatcher !=null )
            requestDispatcher.forward(request, response);
	}

}

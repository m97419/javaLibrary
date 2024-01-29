package registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import registration.dao.BookDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class GetLaonBooksServlet
 */
public class GetLaonBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao = new BookDao(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLaonBooksServlet() {
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
		List dataList = new ArrayList();
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			dataList = bookDao.getHistory(id);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("laonData", dataList);
		RequestDispatcher requestDispatcher;
		requestDispatcher = request.getRequestDispatcher("History.jsp");
		
		if(requestDispatcher !=null )
            requestDispatcher.forward(request, response);
	}

}

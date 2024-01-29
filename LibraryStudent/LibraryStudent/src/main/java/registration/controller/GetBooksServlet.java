package registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import registration.dao.BookDao;
import registration.dao.MessageDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class BookWorkerServlet
 */
public class GetBooksServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao = new BookDao(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBooksServlet() {
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
		int status = Integer.parseInt(request.getParameter("status"));
		String find = request.getParameter("find");
		try {
			dataList = bookDao.getListOfBooks(find);
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("bookData", dataList);
		RequestDispatcher requestDispatcher;
		if(status==0) {
			requestDispatcher = request.getRequestDispatcher("BooksWorker.jsp");
		}
		else {
			requestDispatcher = request.getRequestDispatcher("LaonBooks.jsp");
		}
		
		if(requestDispatcher !=null )
            requestDispatcher.forward(request, response);
	}

}

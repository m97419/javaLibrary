package registration.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import registration.dao.BookDao;
import registration.dao.UserDao;
import registration.model.Books;

import java.io.IOException;

/**
 * Servlet implementation class AddBookServlet
 */
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao = new BookDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
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
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String description = request.getParameter("description");
		
		Books book = new Books();
		
		book.setName(name);
		book.setAuthor(author);
		book.setDescription(description);

		try {
			bookDao.addBook(book);
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("GetBooksServlet");
		System.out.println("!!!!!!!!!!->"+ requestDispatcher);
		if(requestDispatcher !=null )
            requestDispatcher.forward(request, response);
	}

}

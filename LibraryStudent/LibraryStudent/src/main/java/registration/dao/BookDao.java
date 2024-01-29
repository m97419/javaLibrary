package registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import registration.model.Books;
import registration.model.User;

public class BookDao {
	
	public String CONNECTION_STR = "jdbc:mysql://localhost:3306/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

	public List getListOfBooks(String find) throws ClassNotFoundException{
		List dataList = new ArrayList();
		
		String SQL = "SELECT b.* FROM book b LEFT JOIN loan l ON b.id = l.bookId WHERE l.bookId IS NULL AND name like '%?%'";
    	java.sql.Statement stmt;
							
		Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
				if (connection != null) {
				
					System.out.println("Connected to the database students");
	        	}
				
				PreparedStatement preparedStatement = connection.prepareStatement(SQL);
				
				preparedStatement.setString(1,find);
				ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
			
			    System.out.println(rs.getString("name")+" "+rs.getString("author")+" "+rs.getString("description"));
			    dataList.add(rs.getString("name"));
			    dataList.add(rs.getString("author"));	
			    dataList.add(rs.getString("description"));	
			    dataList.add(rs.getString("id"));
			}
			
			rs.close();
		}
		 catch (SQLException e) {
			 e.printStackTrace();
		}
		
		return dataList;
	}
	
	public int deleteBook(int id) throws ClassNotFoundException {
		String DELETE_BOOK_SQL = "DELETE FROM book WHERE id = ?";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
		Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
		
		if (connection != null) {
			
            System.out.println("Connected to the database students");
        }
		              
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BOOK_SQL);
				
		preparedStatement.setInt(1,id);
		
		System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
				
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		return result;
		
	}
	
	public int addBook(Books book) throws ClassNotFoundException{
		
	     String INSERT_BOOK_SQL = "INSERT INTO book(name,author,description)"+
	     " VALUES (?,?,?);";	     

			int result = 0;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
			if (connection != null) {
				
	            System.out.println("Connected to the database students");
	        }
			              
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOK_SQL);
					
			preparedStatement.setString(1,book.getName());
			preparedStatement.setString(2,book.getAuthor());
			preparedStatement.setString(3,book.getDescription());
			
			result = preparedStatement.executeUpdate();
					
			}
			catch(SQLException e) {
				
				e.printStackTrace();
				
			}
			return result;
					
		}
	
	public List getAllLaonBooks(int id) throws ClassNotFoundException{
		String GET_LAON_SQL = "SELECT b.name, b.author, b.description, b.id FROM students.loan l JOIN students.book b ON l.bookId = b.id where l.userId = ?;";
		
		int result = 0;
		List dataList = new ArrayList();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
			if (connection != null) {
				
	            System.out.println("Connected to the database students");
	        }
			              
			PreparedStatement preparedStatement = connection.prepareStatement(GET_LAON_SQL);
					
			preparedStatement.setInt(1,id);
			ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
		
		    dataList.add(rs.getString("name"));
		    dataList.add(rs.getString("author"));	
		    dataList.add(rs.getString("description"));	
		    dataList.add(rs.getString("id"));
		}
		
		rs.close();
	}
	 catch (SQLException e) {
		 e.printStackTrace();
	}
	
	return dataList;
	}
	
	public List getHistory(int id) throws ClassNotFoundException{
		String GET_HISTORY_SQL = "SELECT b.id, b.name, b.author, b.description FROM students.loan l JOIN students.book b ON l.bookId = b.id where l.isReturned = true;";
		java.sql.Statement stmt;
		int result = 0;
		List dataList = new ArrayList();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
			if (connection != null) {
				
	            System.out.println("Connected to the database students");
	        }
			stmt = connection.createStatement();

			ResultSet rs = ((java.sql.Statement) stmt).executeQuery(GET_HISTORY_SQL);
		
		while (rs.next()) {
		
		    dataList.add(rs.getString("name"));
		    dataList.add(rs.getString("author"));	
		    dataList.add(rs.getString("description"));	
		    dataList.add(rs.getString("id"));
		}
		
		rs.close();
	}
	 catch (SQLException e) {
		 e.printStackTrace();
	}
	
	return dataList;
	}
	
}

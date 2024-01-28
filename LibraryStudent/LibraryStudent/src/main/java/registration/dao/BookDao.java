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

	public List getListOfBooks() throws ClassNotFoundException{
		List dataList = new ArrayList();
		
		String SQL = "SELECT b.* FROM book b LEFT JOIN loan l ON b.id = l.bookId WHERE l.bookId IS NULL";
    	java.sql.Statement stmt;
							
		Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
				if (connection != null) {
				
					System.out.println("Connected to the database students");
	        	}
				stmt = connection.createStatement();
		       
				ResultSet rs = ((java.sql.Statement) stmt).executeQuery(SQL);
			
			while (rs.next()) {
			
			    System.out.println(rs.getString("name")+" "+rs.getString("author")+" "+rs.getString("description"));
			    dataList.add(rs.getString("name"));
			    dataList.add(rs.getString("author"));	
			    dataList.add(rs.getString("description"));	
			    dataList.add(rs.getString("id"));
			}
			
			rs.close();
			stmt.close();
		}
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataList;
	}
	
	public int addBook(Books book) throws ClassNotFoundException{
		
	     String INSERT_STUDENT_SQL = "INSERT INTO book(name,author,description)"+
	     " VALUES (?,?,?);";
		
	    /// String CONNECTION_STR = "jdbc:mysql://localhost:3306/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	     

			int result = 0;
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
			if (connection != null) {
				
	            System.out.println("Connected to the database students");
	        }
			              
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL);
					
			preparedStatement.setString(1,book.getName());
			preparedStatement.setString(2,book.getAuthor());
			preparedStatement.setString(3,book.getDescription());
			
			System.out.println(preparedStatement);
			result = preparedStatement.executeUpdate();
					
			}
			catch(SQLException e) {
				
				e.printStackTrace();
				
			}
			return result;
					
		}
	
}

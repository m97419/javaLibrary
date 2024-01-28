package registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import registration.model.User;

public class UserDao {
	
	public String CONNECTION_STR = "jdbc:mysql://localhost:3306/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public int registerUser(User user) throws ClassNotFoundException{
		
     String INSERT_STUDENT_SQL = "INSERT INTO userSimple(userName,pass,address,phone,status)"+
     " VALUES (?,?,?,?,?);";     

		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
		Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
		
		if (connection != null) {
			
            System.out.println("Connected to the database students");
        }
		              
		PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL);
				
		preparedStatement.setString(1,user.getUserName());
		preparedStatement.setString(2,user.getPassword());
		preparedStatement.setString(3,user.getAddress());
		preparedStatement.setString(4,user.getPhoneNum());
		preparedStatement.setInt(5,user.getStatus());
		
		System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
				
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		return result;
				
	}
	
	public List getAllUsers() throws ClassNotFoundException {
		List dataList = new ArrayList();
		
		String GET_ALL_USERS_SQL = "select distinct u.id, u.userName, u.address, u.phone, l.isLoan\r\n"
				+ "from students.usersimple u left join students.loan l\r\n"
				+ "on u.id = l.userId\r\n"
				+ "order by l.isLoan desc";
    	java.sql.Statement stmt;
    	
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	
    	try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
			
				if (connection != null) {
				
					System.out.println("Connected to the database students");
	        	}
				stmt = connection.createStatement();
		       
				ResultSet rs = ((java.sql.Statement) stmt).executeQuery(GET_ALL_USERS_SQL);
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String userName = rs.getString("userName");
				String address = rs.getString("address");
				String phone = rs.getString("phone");
				boolean haveLoans = rs.getBoolean("isLoan");
				User user = new User(id, userName, address, phone, haveLoans);
				dataList.add(user);	    
			}
			
			rs.close();
			stmt.close();
		}
    	 catch (SQLException e) {
 			e.printStackTrace();
 		}
 		
 		return dataList;
	}
	
	public int deleteUser(int id) throws ClassNotFoundException {
		String DELETE_USER_SQL = "DELETE FROM usersimple WHERE id = ?";
		
		int result = 0;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
		Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
		
		if (connection != null) {
			
            System.out.println("Connected to the database students");
        }
		              
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL);
				
		preparedStatement.setInt(1,id);
		
		System.out.println(preparedStatement);
		result = preparedStatement.executeUpdate();
				
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		return result;
		
	}

	public User login(String userName, String password) throws ClassNotFoundException, SQLException{
		String GET_BY_NAME_AND_PASSWORD = "SELECT id, userName, status FROM students.userSimple WHERE username = ? and pass = ?;";
		
		ResultSet rs=null;
		User user = new User();
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		try {
			Connection connection = DriverManager.getConnection(CONNECTION_STR,"root","1234");
		
			if (connection != null) {
				
	            System.out.println("Connected to the database students");
	        }
			              
			PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_NAME_AND_PASSWORD);
					
			preparedStatement.setString(1,userName);
			preparedStatement.setString(2,password);
			
			System.out.println(preparedStatement);
			rs = preparedStatement.executeQuery();
			
		}
		catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		if(rs==null || !rs.next()) return null;
		
		user.setId(rs.getInt("id"));
		user.setUserName(rs.getString("userName"));
		user.setStatus(rs.getInt("status"));
		return user;
		
	}
	
}


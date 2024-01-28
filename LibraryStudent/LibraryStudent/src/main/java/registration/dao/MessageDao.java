package registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
	
	public String CONNECTION_STR = "jdbc:mysql://localhost:3306/students?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	
	public List getListOfMessages() throws ClassNotFoundException{
		List dataList = new ArrayList();
		
		String SQL = "select * from message";
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
			
			    System.out.println(rs.getString("body"));
			    dataList.add(rs.getString("body"));	    
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

}

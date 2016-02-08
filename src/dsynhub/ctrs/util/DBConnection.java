package dsynhub.ctrs.util;


import java.sql.*;

public  class DBConnection {

	
	      public static Connection getconnection()
	      {
		
 	       	   
		 
		  
		  
		  
		  final String url = "jdbc:mysql://localhost:3306/AveTech";
		  final String username = "root";
		  final String password = "root";
		  
		  System.out.println("Loading driver...");

		  try {
		      Class.forName("com.mysql.jdbc.Driver");
		      System.out.println("Driver loaded!");
		  } catch (ClassNotFoundException e) {
		      throw new IllegalStateException("Cannot find the driver in the classpath!", e);
		  }
		  
		  System.out.println("Connecting database...");
		  Connection conn=null;
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		   if(conn!=null)
		   {
			   System.out.println("Database Connected...");
			   return conn;
		   }
		  
		  
		  return conn;
		   
	}
		   
		   
 
}

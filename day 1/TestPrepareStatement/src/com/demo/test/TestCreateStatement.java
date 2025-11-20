package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestCreateStatement {

	public static void main(String[] args) {
	  Connection conn=null;
	  try {
		  DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
		  String url="jdbc:mysql://192.168.10.117/dac99?useSSl=false";
		  conn=DriverManager.getConnection(url,"dac99","welcome");
		  if(conn!=null) {
			  System.out.println("Connection Done.");
		  }else {
			  System.out.println("Connection not done.");
		  }
		  Statement st=conn.createStatement();
		  ResultSet rs=st.executeQuery("select * from student");
		  while(rs.next()) {
			  System.out.println("studentID"+rs.getInt(1));
			  System.out.println("name"+rs.getString(2));
			  System.out.println("rnk"+rs.getInt(3));
			  System.out.println("emailID"+rs.getString(4));
			  System.out.println("userName"+rs.getString(5));
			 System.out.println("--------------------------------------");
		  }
		  int studentID=1023;
		  String name="Ramesh";
		  int rnk=3;
		  String emailID="aabbcc@gamil.com";
		  String userName="ramesh@hotmail.com";
		  
		  String query="insert into student values("+studentID+",'"+name+"',"+rnk+",'"+emailID+"','"+userName+"')";
		  System.out.println(query);
		  int n=st.executeUpdate(query);
		  if(n>0) {
			  System.out.println("Insertion done.");
		  }else {
			  System.out.println("Not Done.");
		  }
	  }
		  catch(SQLException e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}finally{
				try {
					conn.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
	}
}
			
		  
	  
	



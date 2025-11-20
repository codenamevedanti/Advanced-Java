package com.demo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;0
import java.sql.SQLException;

public class TestPrepareStatement {

	public static void main(String[] args) {
		Connection conn=null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			String url="jdbc:mysql://192.168.10.117/dac99?useSSL=false";
			conn=DriverManager.getConnection(url,"dac99","welcome");
			PreparedStatement pst=conn.prepareStatement("select * from student");
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				System.out.println("studentID"+rs.getInt("studentID"));
				System.out.println("name"+rs.getString("name"));
				System.out.println(" rnk"+rs.getInt("rnk"));
				System.out.println("emailID"+rs.getString("emailID"));
				System.out.println("userName"+rs.getString("userName"));
			}
			PreparedStatement pst1=conn.prepareStatement("insert into student values(?,?,?,?,?)");
			
			int studentID=23;
			String name="Rajveer";
			int rnk=10;
			String emailID="aabbcc@gmail.com";
			String userName="rajj@hotmail.com";
			
			pst1.setInt(1,studentID);
			pst1.setString(2,name);
			pst1.setInt(3,rnk);
			pst1.setString(4,emailID);
			pst1.setString(5,userName);
			
			int n=pst1.executeUpdate();
			if(n>0) {
				System.out.println("Insertipon Done.");
			}
			else {
				System.out.println("Not done.");
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
		}

	}



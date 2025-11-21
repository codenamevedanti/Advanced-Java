package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.demo.beans.MyUser;

public class StudentDaoImpl  implements StudentDao {
	static Connection conn =null;
	static PreparedStatement seluser;
	static {
		try {
			conn=DBUtil.getMyConnection();
			seluser=conn.prepareStatement("select uname,email,password from Student where uname=?,email=?,password=?");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public MyUser checkUser(String uname, String pass) {
		
	
	}

}

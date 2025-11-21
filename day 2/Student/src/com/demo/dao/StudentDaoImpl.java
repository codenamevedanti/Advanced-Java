package com.demo.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.demo.beans.Student;

public class StudentDaoImpl implements StudentDao{
static Connection conn;
 static PreparedStatement insStud,deletebyId,findallStudents,findById;
static {
	try {
		conn=DBUtil.getMyConnection();
		insStud=conn.prepareStatement("insert into student values(?,?,?,?,?)");
		deletebyId=conn.prepareStatement("delete from Student where studentId=?");
		findallStudents=conn.prepareStatement(" select * from Students");
		findById=conn.prepareStatement("select * from Student where id=?");
		
		
		
    }catch(SQLException e) {
    	e.printStackTrace();
    }
}
    
	@Override
	public boolean add(Student st) {
		try {
			insStud.setString(1,st.getName());
			insStud.setInt(2,st.getRnk());
			insStud.setInt(3,st.getStudentId());
			insStud.setString(4,st.getUsername());
			insStud.setString(5,st.getEnamilId());
			int n=insStud.executeUpdate();
			return n>0;
			
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	

	@Override
	public Object closeMyConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		List <Student> slst=new ArrayList<>();
		try {
			ResultSet rs=findallStudents.executeQuery();
			while(rs.next()) {
				if(rs.getString(4)!=null || rs.getString(5)!=null ) {
					slst.add(new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5)));
				}else {
					slst.add(new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),null,null));
				}
				
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
			if(slst.size()>0) {
				return slst;
			}else {
				return null;
			}
}


	@Override
	public Student getById(int studentId ) {
		Student st=null;
		try {
			findById.setInt(1, studentId);
			ResultSet rs=findById.executeQuery();
			while(rs.next()) {
				if(rs.getString(4)!=null || rs.getString(5)!=null ) {
					st =new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getString(4),rs.getString(5));
				}else {
					st=new Student(rs.getInt(1),rs.getString(2),rs.getInt(3),null,null);
				}
			}
		}catch(SQLException e) {
				e.printStackTrace();
			}
		return st;
	}

	@Override
	public boolean removeById(int studentId) {
		try {
			deletebyId.setInt(1, studentId);
			int n=deletebyId.executeUpdate();
			if(n>0) {
				return true;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
//	@Override
//	public boolean removeById(int studentID) {
//		try{
//			deletebyId.setInt(1, studentID);
//		
//        int n=deletebyId.executeUpdate();
//        if(n>0) {
//        	return true;
//        }
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return false;
//	}

	
		
		
		
	}


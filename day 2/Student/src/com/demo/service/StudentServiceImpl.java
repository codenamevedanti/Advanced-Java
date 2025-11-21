package com.demo.service;

import java.util.List;
import java.util.Scanner;

import com.demo.beans.Student;
import com.demo.dao.DBUtil;
import com.demo.dao.StudentDao;
import com.demo.dao.StudentDaoImpl;

public class StudentServiceImpl implements StudentService {
      
	 //StudentDao sdao=new StudentDaoImpl();
	private StudentDao sdao;
	
	public StudentServiceImpl() {
		sdao = new StudentDaoImpl() ;
	}

	@Override
	public boolean addnewStudent() {
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter the details of students:");
   	 System.out.println("Enter the name:");
   	 String name=sc.next();
   	 
   	System.out.println("Enetr the rank:");
  	 int rnk=sc.nextInt();
  	 
   	 System.out.println("Enter te student id:"); 
   	 int studentId=sc.nextInt();
   	 
   	 System.out.println("Enter the user name:");
   	 String username=sc.next();
   	 
   	 System.out.println("Enter the mail id:");
   	 String enamilId=sc.next();
   	 
   	 Student st=new Student(studentId, name,rnk,enamilId,username);
   	 return sdao.add(st);	
	}

	@Override
	public void closeMyConnection() {
		 sdao.closeMyConnection();
		
	}

	@Override
	public boolean deleteById() {
		return sdao.removeById();
	}

	@Override
	public List<Student> displayAll() {
		return sdao.getAllStudents();
	}

	@Override
	public Student findByID(int studentId) {
		return sdao.getById(studentId);
	}
   
	
	

		
}

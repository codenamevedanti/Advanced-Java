package com.demo.test;
import java.util.List;
import java.util.Scanner;

import com.demo.beans.Student;
import com.demo.dao.DBUtil;
import com.demo.service.*;

public class TestStudent {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		StudentService s=new StudentServiceImpl();
		
		do {
		System.out.println("1.Add new Student \n 2.Delete by student id \n 3.Display all Students.");
		System.out.println("4.Find by student id: \n 5.Display in Sorted Order.\n 6.Exit");
		System.out.println("Enter your choice: ");
	     choice=sc.nextInt();
	     
	     switch(choice) {
	     case 1->{
	    	 boolean status=s.addnewStudent();
	    	 if(status) {
	    		 System.out.println("Student added Succesfully.");
	    	 }
	    	 else {
	    		 System.out.println("Error");
	    	 }
	     }
	     
	     case 2->{
	    	 System.out.println("Enter the student id:");
	    	 int studentId=sc.nextInt();
	    	 boolean status=s.deleteById();
	    	 if (status) {
	    		 System.out.println("Studdent deleted succesfully.");
	    	 }
	    	 else {
	    		 System.out.println("Error!!!");
	    	 }
	     }
	     
	     
	     case 3->{
	    	 List<Student> slst=s.displayAll();
	    	 slst.forEach(System.out::println);	
	     }
	     
	     
	     case 4->{
	    	 System.out.println("Enetr the student id:");
	    	 int studentId=sc.nextInt();
	    	 Student st=s.findByID(studentId);
	    	 if(st==null) {
	    		 System.out.println("Student not found.");
	    	 }else {
	    		 System.out.println("Student found." +st);
	    	 }
	    	 
	     }
	     case 5->{
	    	 List <Student>slst=s.sortStudentbyName();
	    	 slst.forEach(System.out::println);
	    	 
	     }

	     
	     case 6->{
	    	 System.out.println("Thank you for visiting.");
	    	 sc.close();
	    	 s.closeMyConnection();
	     }
		
		

	}
		}while(choice!=6);
		}
		
	

	  public void closeMyConnection() {
		  DBUtil.closeMyConnection();
	  }
}

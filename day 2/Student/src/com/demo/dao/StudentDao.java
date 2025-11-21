package com.demo.dao;

import java.util.List;

import com.demo.beans.Student;

public interface StudentDao {

	boolean add(Student st);

	//boolean removeById();

	boolean removeById(int studentID);

	Object closeMyConnection();

	List<Student> getAllStudents();

	Student getById();

	Student getById(int studentId);

	boolean removeById();

	

	

	

	

}

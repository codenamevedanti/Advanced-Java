package com.demo.service;

import java.util.List;

import com.demo.beans.Student;

public interface StudentService {

	boolean addnewStudent();

	void closeMyConnection();

	boolean deleteById();

	List<Student> displayAll();

	Student findByID(int studentId);

	

	

}

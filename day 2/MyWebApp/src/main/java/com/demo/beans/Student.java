package com.demo.beans;

public class Student {
	private String name;
	private int rnk;
	private int studentId;
	private String username;
	private String enamilId;
	
	
	public Student() {
		super();
	}


	public Student(String name, int rnk, int studentId, String username, String enamilId) {
		super();
		this.name = name;
		this.rnk = rnk;
		this.studentId = studentId;
		this.username = username;
		this.enamilId = enamilId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getRnk() {
		return rnk;
	}


	public void setRnk(int rnk) {
		this.rnk = rnk;
	}


	public int getStudentId() {
		return studentId;
	}


	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getEnamilId() {
		return enamilId;
	}


	public void setEnamilId(String enamilId) {
		this.enamilId = enamilId;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", rnk=" + rnk + ", studentId=" + studentId + ", username=" + username
				+ ", enamilId=" + enamilId + "]";
	}
	
	
	
	
	
	
}

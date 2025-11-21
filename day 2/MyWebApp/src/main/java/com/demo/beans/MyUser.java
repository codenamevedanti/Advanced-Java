package com.demo.beans;

public class MyUser {
  private String uname;
  private int password;
  private String email;

  public MyUser() {
	super();
}

public MyUser(String uname, int password, String email) {
	super();
	this.uname = uname;
	this.password = password;
	this.email = email;
}

public String getUname() {
	return uname;
}

public void setUname(String uname) {
	this.uname = uname;
}

public int getPassword() {
	return password;
}

public void setPassword(int password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

@Override
public String toString() {
	return "MyUser [uname=" + uname + ", password=" + password + ", email=" + email + "]";
}
  
  
  
  
}

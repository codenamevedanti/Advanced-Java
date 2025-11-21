package com.demo.dao;

import com.demo.beans.MyUser;

public interface StudentDao {

	MyUser checkUser(String uname, String pass);

}

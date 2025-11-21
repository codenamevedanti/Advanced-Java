package com.demo.service;

import com.demo.beans.MyUser;
import com.demo.dao.StudentDao;
import com.demo.dao.StudentDaoImpl;

public class LoginServiceImpl  implements LoginService {
    private StudentDao sdao;
	public LoginServiceImpl() {
	sdao = new StudentDaoImpl();
}


	@Override
	public MyUser validateUser(String uname, String pass) {
		return sdao.checkUser(uname,pass);
	}

}

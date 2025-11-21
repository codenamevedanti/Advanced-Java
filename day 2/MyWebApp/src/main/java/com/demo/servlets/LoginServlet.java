package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import com.demo.beans.MyUser;
import com.demo.service.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
       public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
    	   response.setContentType("text/html");
    	   PrintWriter out=response.getWriter();
    	   String uname=request.getParameter("uname");
    	   String pass=request.getParameter("pass");
    	   LoginService lservice =new LoginServiceImpl();
    	   MyUser user=lservice.validateUser(uname,pass);
    	   if(user!=null) {
    		   RequestDispatcher rd=request.getRequestDispatcher("showproduct");
    		   rd.forward(request, response);
    	   }else {
    		   out.print("Inavlid Credentials!!!");
    		   RequestDispatcher rd=request.getRequestDispatcher("Login.html");
    		   rd.include(request, response);
    	   }
    			   
    			   
       }
}

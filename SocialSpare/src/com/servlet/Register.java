package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.db.UserDBUtil;
import com.model.User;


@WebServlet("/Register")
public class Register extends HttpServlet {
	
    public Register() {
        	
    }

    @Resource(name="jdbc/social")
    private DataSource datasource;
    private UserDBUtil userdb;
    
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try{
			userdb = new UserDBUtil(datasource);
		}catch(Exception e){
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email_id");
		String pass = request.getParameter("passwd");
		String fname = request.getParameter("first_name");
		String lname = request.getParameter("last_name");
		
		User tempUser = new User(email,pass,fname,lname);
		boolean canRegister = tempUser.Register(userdb);
		
		if(canRegister)
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("registersuccess", true);
			dispatcher.forward(request, response);
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("registererror", true);
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

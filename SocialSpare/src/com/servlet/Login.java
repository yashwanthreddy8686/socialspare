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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.db.UserDBUtil;
import com.model.User;


@WebServlet("/Login")
public class Login extends HttpServlet {
	
    public Login() {
      
    	
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
		
		HttpSession session = request.getSession();
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		
		User tempUser = new User(email,pass);
		boolean canLogin = tempUser.login(userdb);
		
		if(canLogin)
		{
			session.setAttribute("user", tempUser);
			response.sendRedirect("Home");
		}
		else
		{
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			request.setAttribute("loginerror", true);
			dispatcher.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

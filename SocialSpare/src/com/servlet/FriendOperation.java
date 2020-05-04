package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.Post;
import com.model.User;

@WebServlet("/FriendOperation")
public class FriendOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FriendOperation() {
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		if(request.getParameter("message") != null)
		{
			String tempreceiver = request.getParameter("message");
			session.setAttribute("receiver", tempreceiver);
			response.sendRedirect("Message.jsp");
		}
		else if(request.getParameter("view") != null)
		{
			String tempEmail = request.getParameter("view");
			User tempUser = new User(tempEmail);
			session.setAttribute("user", tempUser);
			response.sendRedirect("Profile");
		}
		
		else if(request.getParameter("unfriend") != null)
		{
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

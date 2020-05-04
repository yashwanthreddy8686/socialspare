package com.servlet;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.db.MessageDBUtil;
import com.db.postDBUtil;
import com.model.User;

@WebServlet("/Message")
public class Message extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Message() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(name="jdbc/social")
    private DataSource datasource;
    private MessageDBUtil messagedb;
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			messagedb = new MessageDBUtil(datasource);			
		
		}catch(Exception ex) {
			
			throw new ServletException(ex);
		
		}
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		if(request.getParameter("send") != null)
		{
			String receiver = (String) session.getAttribute("receiver");
			String tempmessage = request.getParameter("message");
			user.SendMessage(receiver,tempmessage,messagedb);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Message.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

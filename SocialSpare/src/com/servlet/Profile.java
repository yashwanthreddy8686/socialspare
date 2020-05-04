package com.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.db.FriendDBUtil;
import com.db.postDBUtil;
import com.model.Post;
import com.model.User;


@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Profile() {
      
    }
    
    @Resource(name="jdbc/social")
    private DataSource datasource;
    private postDBUtil postdb;
    private FriendDBUtil friendb;
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try{
			postdb = new postDBUtil(datasource);
			friendb = new FriendDBUtil(datasource);
		}catch(Exception e){
			throw new ServletException(e);
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		ArrayList<Post> alluserPosts = new ArrayList<>();
		
		try {
			 alluserPosts = postdb.getAllUserPosts(user.getEmail());
			 request.setAttribute("allUserPosts", alluserPosts);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		ArrayList<User> allUserFriends = new ArrayList<>();
		
		try {
			allUserFriends = friendb.getAllUserFriends(user.getEmail());
			 request.setAttribute("allUserFriends", allUserFriends);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
			dispatcher.forward(request, response);
			
		}
		
		if(request.getParameter("logout") != null)
		{
			String tempEmail = request.getParameter("logout");
			User tempUser = new User(tempEmail);
			session.setAttribute("user", tempUser);
			response.sendRedirect("Logout");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}

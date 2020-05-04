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
import javax.sql.DataSource;

import com.db.UserDBUtil;
import com.db.postDBUtil;
import com.model.Post;

@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Home() {
      
    	
    }
    
    @Resource(name="jdbc/social")
    private DataSource datasource;
    private postDBUtil postdb;
    
    

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try{
			postdb = new postDBUtil(datasource);
		}catch(Exception e){
			throw new ServletException(e);
		}
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Post> allPosts = new ArrayList<>(); 
		
		try {
			 allPosts = postdb.getAllPosts();
			 request.setAttribute("allPosts", allPosts);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

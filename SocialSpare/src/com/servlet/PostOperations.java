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

import com.db.SavePostsDBUtil;
import com.db.likesDBUtil;
import com.db.postDBUtil;
import com.model.User;


@WebServlet("/PostOperations")
public class PostOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PostOperations() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(name="jdbc/social")
    private DataSource datasource;
    private postDBUtil postdb;
    private likesDBUtil likedb;
    private SavePostsDBUtil savedb;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			
			postdb = new postDBUtil(datasource);
			likedb = new likesDBUtil(datasource);
			savedb = new SavePostsDBUtil(datasource);
		
		}catch(Exception ex) {
			
			throw new ServletException(ex);
		
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		if(request.getParameter("like") != null)
		{
			int postliked = Integer.parseInt(request.getParameter("like"));
			try {
					boolean like = likedb.UpdateLikes(postliked,user.getEmail());
					
					if(like) {
					request.setAttribute("liked", true);
					}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
				dispatcher.forward(request, response);
				
			}
		}
		else if(request.getParameter("unlike") != null)
		{
			int postliked = Integer.parseInt(request.getParameter("like"));
			try {
					boolean like = likedb.UpdateLikes(postliked,user.getEmail());
					
					if(like) {
					request.setAttribute("liked", false);
					}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
				dispatcher.forward(request, response);
				
			}
			
		}
		
		else if(request.getParameter("edit") != null)
		{
			
		}
		else if(request.getParameter("save") != null)
		{
			int postsave = Integer.parseInt(request.getParameter("save"));
			try {
					boolean saved = savedb.PostSave(postsave,user.getEmail());
					
					if(saved) {
					request.setAttribute("saved", true);
					}
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				RequestDispatcher dispatcher = request.getRequestDispatcher("Home");
				dispatcher.forward(request, response);
				
			}
		}
		else if(request.getParameter("delete") != null)
		{
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

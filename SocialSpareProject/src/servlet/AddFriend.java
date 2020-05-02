package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import db.FriendDBUtil;
import model.Friend;
import model.User;

/**
 * Servlet implementation class Friend
 */
@WebServlet("/Friend")
public class AddFriend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFriend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
        PrintWriter out=response.getWriter();  
        String email=request.getParameter("friend_email");  
        String user_email=user.getEmail();
        Friend friend=new Friend();  
        friend.setFriendEmail(email); 
        friend.setUserEmail(user_email);
        friend.setStatus("1");
        int status=FriendDBUtil.save(friend);  
        if(status>0){  
            //out.print("<p>Record saved successfully!</p>");  
            request.getRequestDispatcher("profile.jsp").include(request, response);  
        }else{  
            out.println("Sorry! unable to save record");  
        }  
        out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

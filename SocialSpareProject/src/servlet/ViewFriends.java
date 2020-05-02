package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.FriendDBUtil;
import model.Friend;

/**
 * Servlet implementation class ViewFriends
 */
@WebServlet("/ViewFriends")
public class ViewFriends extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewFriends() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<a href='profile.jsp'>Profile</a>");  
        out.println("<h1>Friends List</h1>");  
        List<Friend> list=FriendDBUtil.getAllFriends();  
        out.print("<table border='1' width='100%'");  
        out.print("<tr><th>Friend's Email</th><th>Delete</th>");  
        for(Friend friend:list){  
         out.print("<tr><td>"+friend.getFriendEmail()+"</td><td><a href='DeleteFriend?friend_email="+friend.getFriendEmail()+"'>delete</a></td></tr>");  
        }  
        out.print("</table>");  
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

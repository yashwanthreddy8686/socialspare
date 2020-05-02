package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Friend;

public class FriendDBUtil {
	public static Connection getConnection(){  
        Connection con=null;  
        try{  
        	Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/social-spark?useSSL=false", "root", "abc123...");
        }catch(Exception e){System.out.println(e);}  
        return con;  
    }  
	
    public static int save(Friend friend){  
        int status=0;  
        try{  
            Connection con=FriendDBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("insert into friend(friend_email,user_email,status) values (?,?,?)");  
            ps.setString(1,friend.getFriendEmail());  
            ps.setString(2,friend.getUserEmail());  
            ps.setString(3,friend.getStatus());  
            status=ps.executeUpdate();  
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        }  
        return status;  
    }  
    
    public static int delete(String email){  
        int status=0;  
        try{  
            Connection con=FriendDBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from friend where friend_email=?");  
            ps.setString(1,email);  
            status=ps.executeUpdate();  
            con.close();  
        }catch(Exception e){
        	e.printStackTrace();
        }  
        return status;  
    }  
    
    public static Friend getEmployeeById(String email){  
        Friend friend=new Friend();  
          
        try{  
            Connection con=FriendDBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from friend where friend_email=?");  
            ps.setString(1,email);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                friend.setFriendEmail(rs.getString(1));  
                friend.setUserEmail(rs.getString(2));  
                friend.setStatus(rs.getString(3));  
            }  
            con.close();  
        }catch(Exception ex){
        	ex.printStackTrace();
        }  
        return friend;  
    }  
    
    public static List<Friend> getAllFriends(){  
        List<Friend> list=new ArrayList<Friend>();  
          
        try{  
            Connection con=FriendDBUtil.getConnection();  
            PreparedStatement ps=con.prepareStatement("select * from friend");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Friend friend=new Friend();  
                friend.setFriendEmail(rs.getString(1));  
                friend.setUserEmail(rs.getString(2));  
                friend.setStatus(rs.getString(3));  
                list.add(friend);  
            }  
            con.close();  
        }catch(Exception e){
        	e.printStackTrace();
        }  
        return list;  
    }  
}

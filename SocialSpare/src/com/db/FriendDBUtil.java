package com.db;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;

import javax.sql.DataSource;

import com.model.Post;
import com.model.User;

public class FriendDBUtil 
{
	private DataSource datasource;

	public FriendDBUtil(DataSource datasource) {
		this.datasource = datasource;
	}

	public ArrayList<User> getAllUserFriends(String email) throws Exception {
		
		Connection conn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		ArrayList<User> allUserFriends = new ArrayList<>();
		
		try {
			conn = this.datasource.getConnection();
			String sql = "select friend_email from friends where user_email = ? ";
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				String tempemail = rs.getString("friend_email");
				allUserFriends.add(new User(tempemail));
			}
			
			
		} 
		finally
		{
			close(conn,st,pst,rs);
			
		}
		
		return allUserFriends;
	}
	
	private void close(Connection conn,Statement st,PreparedStatement pst,ResultSet rs)
	{
		try {
			if(conn != null) {
				conn.close();
			}
			if(st != null) {
				st.close();
			}
			if(pst != null) {
				pst.close();
			}
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

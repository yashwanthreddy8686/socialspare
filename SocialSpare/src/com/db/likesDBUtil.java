package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class likesDBUtil 
{
	private DataSource datasource;

	public likesDBUtil(DataSource datasource) {
		this.datasource = datasource;
	}

	public boolean UpdateLikes(int postid,String UserEmail) throws Exception
	{

		Connection conn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = this.datasource.getConnection();
			String sql = "update posts SET likes = likes+1 where idposts = ? ";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, postid);
			pst.executeUpdate();
			sql = "insert into likes (post_id,user_email) values (?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, postid);
			pst.setString(2, UserEmail);
			pst.executeUpdate();
		}
		finally
		{
			close(conn,st,pst,rs);
			
		}
		return true;
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

package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class SavePostsDBUtil {
	
	private DataSource datasource;

	public SavePostsDBUtil(DataSource datasource) {
		this.datasource = datasource;
	}

	public boolean PostSave(int postsave, String email) throws Exception {
	
		Connection conn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = this.datasource.getConnection();
			String sql = "insert into save_posts (posts_id,email) values (?,?)";
			pst = conn.prepareStatement(sql);
			pst.setInt(1,postsave);
			pst.setString(2, email);
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

package com.db;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
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



public class postDBUtil {

	private DataSource datasource;

	public postDBUtil(DataSource datasource) {
		this.datasource = datasource;
	}

	public ArrayList<Post> getAllPosts() throws Exception
	{
		Connection conn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		ArrayList<Post> allPosts = new ArrayList<>();
		
		try {
			conn = this.datasource.getConnection();
			String sql = "select * from posts";
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				int tempid = rs.getInt("idposts");
				String tempemail = rs.getString("email_id");
				String tempcontent = rs.getString("content");
				String temppostdate = rs.getString("posted_at");
				int templikes = rs.getInt("likes");
				Blob blob = rs.getBlob("image");
				
                InputStream inputStream = blob.getBinaryStream();
                byte[] buffer = new byte[4096];
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                String tempimage = Base64.getEncoder().encodeToString(imageBytes);
   
                inputStream.close();
                outputStream.close();
				
				allPosts.add(new Post(tempid,tempemail,tempcontent,tempimage,temppostdate,templikes));
			}
			
			
		} 
		finally
		{
			close(conn,st,pst,rs);
			
		}
		
		return allPosts;
		
	}
	
	public ArrayList<Post> getAllUserPosts(String email) throws Exception 
	{
		Connection conn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		ArrayList<Post> allUserPosts = new ArrayList<>();
		
		try {
			conn = this.datasource.getConnection();
			String sql = "select * from posts where email_id = ? ";
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			
			while(rs.next())
			{
				int tempid = rs.getInt("idposts");
				String tempemail = rs.getString("email_id");
				String tempcontent = rs.getString("content");
				String temppostdate = rs.getString("posted_at");
				int templikes = rs.getInt("likes");
				Blob blob = rs.getBlob("image");
				
                InputStream inputStream = blob.getBinaryStream();
                byte[] buffer = new byte[4096];
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                int bytesRead = -1;
                 
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                 
                byte[] imageBytes = outputStream.toByteArray();
                String tempimage = Base64.getEncoder().encodeToString(imageBytes);
   
                inputStream.close();
                outputStream.close();
				
				allUserPosts.add(new Post(tempid,tempemail,tempcontent,tempimage,temppostdate,templikes));
			}
			
			
		} 
		finally
		{
			close(conn,st,pst,rs);
			
		}
		
		return allUserPosts;
		
	}
	
	public void insertPost(Post temppost) throws Exception {
		
		Connection conn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		FileInputStream fis = null;
		
		String content = temppost.getContent();	
		String email = temppost.getEmail();	
		String images = temppost.getImage();	
		
		try {
		conn = this.datasource.getConnection();
		File img = new File("C:/Users/ymaddula/Downloads/profile-photo1.jpeg");
		String sql = "insert into posts (idposts,email_id,content,image,posted_at,likes)"+"values ('3',?,'Eat',?,curdate(),'0')";
		pst = conn.prepareStatement(sql);
		pst.setString(1, email);
		//pst.setString(2, content);
		fis = new FileInputStream(img);
		pst.setBinaryStream(2, (InputStream) fis,(int)(img.length()));
		pst.executeUpdate();
		}
		finally {
			close(conn,st,pst,rs);
		}
		
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

package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.model.User;

public class UserDBUtil
{
	private DataSource datasource;

	public UserDBUtil(DataSource datasource) {
		this.datasource = datasource;
	}

	public User findUser(String email) throws Exception{
		
		Connection conn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		User founduser = null;
		
		try {
			conn = this.datasource.getConnection();
			String sql = "select * from users where email=? ";
			pst = conn.prepareStatement(sql);
			pst.setString(1, email);
			rs = pst.executeQuery();
			
			if(rs.next())
			{
				String tempemail = rs.getString("email");
				String temppassword = rs.getString("password");
				String tempfname = rs.getString("fname");
				String templname = rs.getString("lname");
				
				founduser = new User(tempemail,temppassword,tempfname,templname);
			}
			
			
		} 
		finally
		{
			close(conn,st,pst,rs);
			
		}
		
		return founduser;
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

	public boolean Register(String email, String fname, String lname, String pass) 
	{
		Connection conn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = this.datasource.getConnection();
			String sql = " insert into users (email,password,fname,lname)" + " values (?, ? ,?,?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1,email);
			pst.setString(2,pass);
			pst.setString(3,fname);
			pst.setString(4,lname);
			pst.execute();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally
		{
			close(conn,st,pst,rs);
			
		}
		
		return true;
		
	}

}

package com.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

public class MessageDBUtil 
{

	private DataSource datasource;
	
	public MessageDBUtil(DataSource datasource) {
		
		this.datasource = datasource;
	}

	public void insertMessage(String email, String receiver, String tempmessage) throws Exception {
		
		Connection conn = null;
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		try {
			conn = this.datasource.getConnection();
			String sql = "insert into messages (messages_id,user_email,friend_email,message,sent_date,message_status)" + " values ('2',?,?,?,curdate(),?)";
			pst = conn.prepareStatement(sql);
			pst.setString(1,email);
			pst.setString(2, receiver);
			pst.setString(3,tempmessage);
			pst.setBoolean(4, false);
			pst.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		finally
		{
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

package com.model;

import java.io.InputStream;
import java.util.ArrayList;

import com.db.MessageDBUtil;
import com.db.UserDBUtil;
import com.db.postDBUtil;

public class User 
{
	private String email;
	private String pass;
	private String fname;
	private String lname;
	
	public User(String email, String pass, String fname, String lname) {
		this.email = email;
		this.pass = pass;
		this.fname = fname;
		this.lname = lname;
	}
	
	public User(String email)
	{
		this.email = email;
	}

	public boolean login(UserDBUtil userdb)
	{
		try 
		{
			User tempuser = userdb.findUser(this.email);
			
			if(tempuser != null)
			{
				if(this.pass.equals(tempuser.getPass()))
				{
					this.email = tempuser.getEmail();
					this.fname = tempuser.getFname();
					this.lname = tempuser.getLname();
					this.pass = null;
					
					return true;
				}
			}

		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean Register(UserDBUtil userdb)
	{
		
		try {
			User tempuser = userdb.findUser(this.email);
			
			if(tempuser == null) 
			{
				return userdb.Register(this.email,this.fname,this.lname,this.pass);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean createPost(String content, String image, postDBUtil postdb) {
		
		Post temppost = new Post(this.email,content,image);
		try {
			postdb.insertPost(temppost);
			return true;	
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}	
		
		return false;
	}
	

	public void SendMessage(String receiver, String tempmessage, MessageDBUtil messagedb) {
		
		try {
			messagedb.insertMessage(this.email,receiver,tempmessage);
		}
		catch (Exception e) {
			
			e.printStackTrace();
		}	
		
	}
	
	
	
	
	
	
	
	
	
	
//	public ArrayList<Post> viewProfile(postDBUtil postdb)
//	{
//		try {
//			postdb.viewUserPost(this.email);
//			
//		} catch (Exception e) {
//		
//			e.printStackTrace();
//		}	
//	}

	public User(String email, String pass) {
		this.email = email;
		this.pass = pass;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPass() {
		return this.pass;
	}

	public String getFname() {
		return this.fname;
	}

	public String getLname() {
		return this.lname;
	}

	@Override
	public String toString() {
		return this.email;
	}

}

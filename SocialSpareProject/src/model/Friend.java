package model;

public class Friend { 
	
	private String friend_email, user_email, status;  
	 
	public String getFriendEmail() {  
	    return friend_email;  
	}
	
	public void setFriendEmail(String friend_email) {  
	    this.friend_email = friend_email;  
	}
	
	public String getUserEmail() {  
	    return user_email;  
	}  
	
	public void setUserEmail(String user_email) {  
	    this.user_email = user_email;  
	}  
	
	public String getStatus() {  
	    return status;  
	} 
	
	public void setStatus(String status) {  
	    this.status = status;  
	}   
}

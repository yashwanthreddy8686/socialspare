package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Post {
	private String id;
	private String content;
	private  String image;
	private String date;
	private String email;
	
	public Post(String id, String content, String image, String date, String email) {
		this.id = id;
		this.content = content;
		this.image = image;
		this.date = date;
		this.email = email;
	}
	
	public Post(String email,String content, String image) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		this.email = email;
		this.content = content;
		this.image = image;
		this.id = null;
		this.date = sdf.format(new Date());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}

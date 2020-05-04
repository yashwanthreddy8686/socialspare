package com.model;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Post {

	private int id;
	private String email;
	private String content;
	private String image;
	private String postDate;
	private int likes;
	
	//Constructor for getting the data from DataBase
	public Post(int id, String email, String content, String image, String postDate,int likes) {
		super();
		this.id = id;
		this.email = email;
		this.content = content;
		this.image = image;
		this.postDate = postDate;
		this.likes = likes;
	}
	
	public Post(String email, String content, String image) {
		super();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		this.email = email;
		this.content = content;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPostDate() {
		return postDate;
	}

	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	
}

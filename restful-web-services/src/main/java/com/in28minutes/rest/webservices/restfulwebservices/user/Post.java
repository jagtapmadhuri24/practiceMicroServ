package com.in28minutes.rest.webservices.restfulwebservices.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Post {

	
	@Id
	@GeneratedValue
	@Column
	private Integer id;
	
	
	@Column
	private String desc;
	
	//1 User can have many Post
	@ManyToOne(fetch=FetchType.LAZY)
	private User user;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Post [id=" + id + ", desc=" + desc + "]";
	}
	
	
	
	
	
	
}

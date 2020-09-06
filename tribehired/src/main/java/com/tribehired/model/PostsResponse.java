/**
 * 
 */
package com.tribehired.model;

/**
 * @author User
 *
 */
public class PostsResponse {
	
	public String post_id;
	public String post_title;
	public String post_body;
	public Integer  total_number_of_comments;
	
	
	public String getPost_id() {
		return post_id;
	}
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	public String getPost_title() {
		return post_title;
	}
	public void setPost_title(String post_title) {
		this.post_title = post_title;
	}
	public String getPost_body() {
		return post_body;
	}
	public void setPost_body(String post_body) {
		this.post_body = post_body;
	}
	public Integer getTotal_number_of_comments() {
		return total_number_of_comments;
	}
	public void setTotal_number_of_comments(Integer total_number_of_comments) {
		this.total_number_of_comments = total_number_of_comments;
	}

}

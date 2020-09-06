/**
 * 
 */
package com.tribehired.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author User
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Posts {
	
	@JsonProperty("postId")
	public String post_id;
	@JsonProperty("title")
	public String post_title;
	@JsonProperty("body")
	public String post_body;
	@JsonProperty("id")
	public String id;
	@JsonProperty("name")
	public String name;
	
	
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

}

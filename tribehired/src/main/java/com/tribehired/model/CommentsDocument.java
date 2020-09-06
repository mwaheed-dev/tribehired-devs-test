/**
 * 
 */
package com.tribehired.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.SolrDocument;

/**
 * @author User
 *
 */
@SolrDocument(solrCoreName = "CommentsDocument")
public class CommentsDocument {

	
	public CommentsDocument() {
	}

	@Id
	@Field
	private String id;
	@Field
	private String postId;

	@Field
	private String name;
	
	@Field
	private String email;
	
	@Field
	private String body;
	
	 public CommentsDocument(String id, String postId, String name,String email,String body){
		    this.id = id;
		    this.postId = postId;
		    this.name = name;
		    this.email=email;
		    this.body=body;
		  }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	

}

/**
 * 
 */
package com.tribehired.services;

import java.util.List;
import java.util.Map;

import com.tribehired.model.CommentsDocument;
import com.tribehired.model.PostsResponse;

/**
 * @author User
 *
 */
public interface Comments {
	
	public List<CommentsDocument> getComments();
	public PostsResponse getSinglePost(String post_id);
	public List<PostsResponse> viewAllPosts();
	public List<PostsResponse> getListOfTopPosts();
	public List<PostsResponse> searchComment(Map<String,String> searchParam);
	List<CommentsDocument> findByName(String matcher);

}

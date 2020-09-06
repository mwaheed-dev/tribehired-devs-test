/**
 * 
 */
package com.tribehired.dao;

import java.util.Collection;
import java.util.List;

/**
 * @author User
 *
 */
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.tribehired.model.CommentsDocument;

public interface CommentsRepository extends SolrCrudRepository<CommentsDocument, String> {

	List<CommentsDocument> findByNameEndsWith(String title); 

	List<CommentsDocument> findByNameStartsWith(String title); 

	List<CommentsDocument> findByEmailEndsWith(String type); 
	List<CommentsDocument> findByEmailStartsWith(String type);
	
	List<CommentsDocument> findByNameLike(Collection<String> name);
	List<CommentsDocument> findByNameContaining(String name);
	
	List<CommentsDocument> findByNameOrPostId(String name, String postId); 
	List<CommentsDocument> findByNameAndPostId(String name, String postId);
	
	List<CommentsDocument> findByIdAndNameAndPostId(String id,String name, String postId);
	List<CommentsDocument> findByIdAndNameAndPostIdAndEmailAndBody(String id,String name, String postId,String email,String body);
	List<CommentsDocument> findByIdOrNameOrPostId(String id,String name, String postId);
	List<CommentsDocument> findByIdOrNameOrPostIdOrEmailOrBody(String id,String name, String postId,String email,String body);
	
	List<CommentsDocument> findByPostId(String postId);
	List<CommentsDocument> findByName(String matcher);

}

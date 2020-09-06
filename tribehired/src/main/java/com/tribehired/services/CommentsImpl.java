/**
 * 
 */
package com.tribehired.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.tribehired.dao.CommentsRepository;
import com.tribehired.model.CommentsDocument;
import com.tribehired.model.Posts;
import com.tribehired.model.PostsResponse;

/**
 * @author User
 *
 */
@Service
public class CommentsImpl implements Comments {
	
	@Autowired
	private CommentsRepository documentRepository;
	
	@Autowired
	private Environment env;

	private RestTemplate restTemplate;

	public CommentsImpl(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@Override
	public List<CommentsDocument> getComments() {
		
		String url = env.getProperty("comments.url");
		CommentsDocument[] response = new RestTemplate().exchange(url, HttpMethod.GET, null, CommentsDocument[].class).getBody();
		List<CommentsDocument> postResponseList = Arrays.stream(response).collect(Collectors.toList());
		return postResponseList;
	}

	@Override
	public PostsResponse getSinglePost(String post_id) {
		
		String url = env.getProperty("singleposts.url");
		Posts postResponse = restTemplate.getForObject(url + post_id, Posts.class);

		PostsResponse postsResponse = new PostsResponse();
		postsResponse.setPost_id(postResponse.getPost_id());
		postsResponse.setPost_title(postResponse.getName());
		postsResponse.setPost_body(postResponse.getPost_body());

		return postsResponse;
	}

	@Override
	public List<PostsResponse> viewAllPosts() {
		String url = env.getProperty("posts.url");
		List<PostsResponse> postResponseList = new ArrayList<PostsResponse>();
		Posts[] response = new RestTemplate().exchange(url, HttpMethod.GET, null, Posts[].class).getBody();
		for (Posts post : response) {
			PostsResponse postsResponse = new PostsResponse();
			postsResponse.setPost_id(post.getId());
			postsResponse.setPost_title(post.getPost_title());
			postsResponse.setPost_body(post.getPost_body());
			postResponseList.add(postsResponse);
		}
		return postResponseList;
	}
	
	public List<PostsResponse> getListOfTopPosts() {
		List<PostsResponse> postResponseList = new ArrayList<PostsResponse>();
		String commentsURL = env.getProperty("comments.url");
		Posts[] commentsResponse = new RestTemplate().exchange(commentsURL, HttpMethod.GET, null, Posts[].class).getBody();
		String url = env.getProperty("posts.url");
		
		Posts[] postResponse = new RestTemplate().exchange(url, HttpMethod.GET, null, Posts[].class).getBody();
		
		PostsResponse postsResponse =null;
		
		for (Posts post : postResponse) {
			int count=0;
			for(Posts comments:commentsResponse) {
				if(post.getId().equals(comments.getPost_id())) {
					count++;
				}
			}
			postsResponse = new PostsResponse();
			postsResponse.setPost_id(post.getId());
			postsResponse.setPost_title(post.getPost_title());
			postsResponse.setPost_body(post.getPost_body());	
			postsResponse.setTotal_number_of_comments(count);
			postResponseList.add(postsResponse);
		}
		return postResponseList;
		
	}

	@Override
	public List<PostsResponse> searchComment(Map<String,String> searchParam) {
		
		List<PostsResponse> postResponseList = new ArrayList<PostsResponse>();
		return postResponseList;
	}

	@Override
	public List<CommentsDocument> findByName(String matcher) {
		return documentRepository.findByName(matcher);
	}

}

/**
 * 
 */
package com.tribehired.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tribehired.dao.CommentsRepository;
import com.tribehired.model.CommentsDocument;
import com.tribehired.model.PostsResponse;
import com.tribehired.services.Comments;

/**
 * @author User
 *
 */
@RestController
public class ServiceController {

	private static final Logger log = LoggerFactory.getLogger(ServiceController.class);

	@Autowired
	private Comments comments;

	@Autowired
	private CommentsRepository documentRepository;

//	@GetMapping(value = "/getpostsById")
//	public ResponseEntity<PostsResponse> getpostsById(@RequestParam(name = "post_id") String post_id) {
//		log.info("=========service getpostsById call start ===============");
//		PostsResponse postResponse = comments.getSinglePost(post_id);
//		log.info("=========service getpostsById call start =========");
//		return new ResponseEntity<>(postResponse, HttpStatus.OK);
//	}

	@GetMapping("/getListOfTopPosts")
	public ResponseEntity<?> getListOfTopPosts() {

		log.info("============getListOfTopPosts call start");
		List<PostsResponse> postResponseList = comments.getListOfTopPosts();
		log.info("==========getListOfTopPosts call end");
		return new ResponseEntity<>(postResponseList, HttpStatus.OK);

	}

	@PostMapping("/saveAllComments")
	public String saveAllComments() {
		// Store Documents
		List<CommentsDocument> commentsList = comments.getComments();
		documentRepository.saveAll(commentsList);
		return "documents saved !!! " + commentsList.size();
	}

	@GetMapping("/getAll")
	public List<CommentsDocument> getAllDocs() {
		List<CommentsDocument> documents = new ArrayList<>();
		// iterate all documents and add it to list
		for (CommentsDocument doc : this.documentRepository.findAll()) {
			documents.add(doc);
		}
		return documents;
	}

	@GetMapping("/findByNameEndsWith/{name}")
	public List<?> findByNameEndsWith(@PathVariable String name) {

		log.info("findByNameEndsWith called");

		List<CommentsDocument> documentAll = this.getAllDocs();
		if (documentAll == null || documentAll.isEmpty()) {
			log.info("data not available in solr, add in solr");
			this.saveAllComments();
		}
		List<CommentsDocument> documents = new ArrayList<>();
		// iterate all documents and add it to list
		for (CommentsDocument doc : this.documentRepository.findByNameEndsWith(name)) {
			documents.add(doc);
		}
		return documents;
	}

	@GetMapping("/findByNameOrPostId/{name}/{postId}")
	public List<CommentsDocument> findByNameEndsWith(@PathVariable String name, @PathVariable String postId) {

		log.info("findByNameEndsWith called");

		return this.documentRepository.findByNameOrPostId(name, postId);
	}

	@GetMapping("/findByNameAndPostId/{name}/{postId}")
	public List<CommentsDocument> findByNameAndPostId(@PathVariable String name, @PathVariable String postId) {

		log.info("findByNameAndPostId called");

		return this.documentRepository.findByNameAndPostId(name, postId);
	}

	@GetMapping("/findByPostId/{id}")
	public List<CommentsDocument> findById(@PathVariable String id) {

		log.info("findByPostId called");

		return this.documentRepository.findByPostId(id);
	}

	@GetMapping("/findByName/{name}")
	public List<CommentsDocument> findByName(@PathVariable String name) {
		log.info("findByName called");

		return this.documentRepository.findByName(name);
	}

	@GetMapping("/findByIdOrNameOrPostId/{id}/{name}/{postId}")
	public List<CommentsDocument> findByIdOrNameOrPostId(@PathVariable String id, @PathVariable String name,
			@PathVariable String postId) {
		log.info("findByIdOrNameOrPostId called");

		return this.documentRepository.findByIdOrNameOrPostId(id, name, postId);
	}

	@GetMapping("/filterWithAllFields/{id}/{name}/{postId}/{email}/{body}")
	public List<CommentsDocument> findByIdAndNameAndPostIdAndEmailAndBody(@PathVariable String id,
			@PathVariable String name, @PathVariable String postId, @PathVariable String email,
			@PathVariable String body) {

		log.info("filterWithAllFields called");

		List<CommentsDocument> documentAll = this.getAllDocs();
		if (documentAll == null || documentAll.isEmpty()) {
			log.info("data not available in solr, add in solr");
			this.saveAllComments();
		}
		return this.documentRepository.findByIdAndNameAndPostIdAndEmailAndBody(id, name, postId, email, body);
	}

	@GetMapping("/findByIdOrNameOrPostIdOrEmailOrBody/{id}/{name}/{postId}/{email}/{body}")
	public List<CommentsDocument> findByIdOrNameOrPostIdOrEmailOrBody(@PathVariable String id,
			@PathVariable String name, @PathVariable String postId, @PathVariable String email,
			@PathVariable String body) {

		log.info("findByIdOrNameOrPostIdOrEmailOrBody called");
		List<CommentsDocument> documentAll = this.getAllDocs();
		if (documentAll == null || documentAll.isEmpty()) {
			log.info("data not available in solr, add in solr");
			this.saveAllComments();
		}
		return this.documentRepository.findByIdOrNameOrPostIdOrEmailOrBody(id, name, postId, email, body);
	}

}

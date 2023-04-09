package com.socialMediaPlatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.socialMediaPlatform.entity.Post;
import com.socialMediaPlatform.exception.PostException;
import com.socialMediaPlatform.exception.UserException;
import com.socialMediaPlatform.service.PostService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {

	/**
	 * postService : Dependency of PostService.
	 */
	@Autowired
	private PostService postService;

	/**
	 * taking the request from the user and adding post to the database by taking the data.
	 */
	@PostMapping
	public ResponseEntity<Post> addPostHandler(@RequestParam(name = "user_id") Integer user_id,
			@Valid @RequestBody Post post) throws PostException, UserException {
		return new ResponseEntity<Post>(postService.addPost(user_id, post), HttpStatus.CREATED);
	}

	/**
	 * taking the request from the user and returning post details of a specific id.
	 */
	@GetMapping("{id}")
	public ResponseEntity<Post> getPostHandler(@PathVariable Integer id) throws PostException {
		return new ResponseEntity<Post>(postService.getPost(id), HttpStatus.OK);
	}

	/**
	 * taking the request from the user and returning updated post details of a specific id.
	 */
	@PutMapping("{id}")
	public ResponseEntity<Post> updatePostHandler(@PathVariable Integer id, @Valid @RequestBody Post post)
			throws PostException {
		return new ResponseEntity<Post>(postService.updatePost(id, post), HttpStatus.OK);
	}

	/**
	 * taking the request from the user and returning post details of a specific id after deleting from database.
	 */
	@DeleteMapping("{id}")
	public ResponseEntity<Post> deletePostHandler(@PathVariable Integer id) throws PostException {
		return new ResponseEntity<Post>(postService.deletePost(id), HttpStatus.OK);
	}

	/**
	 * taking the request from the user and returning post details of a specific id after post is liked.
	 */
	@PostMapping("{id}/like")
	public ResponseEntity<Post> updatePostIncrementLikeHandler(@PathVariable Integer id) throws PostException {
		return new ResponseEntity<Post>(postService.updatePostIncrementLike(id), HttpStatus.ACCEPTED);
	}

	/**
	 * taking the request from the user and returning post details of a specific id after post is disliked.
	 */
	@PostMapping("{id}/unlike")
	public ResponseEntity<Post> updatePostDecrementLikeHandler(@PathVariable Integer id) throws PostException {
		return new ResponseEntity<Post>(postService.updatePostDecrementLike(id), HttpStatus.ACCEPTED);
	}

}

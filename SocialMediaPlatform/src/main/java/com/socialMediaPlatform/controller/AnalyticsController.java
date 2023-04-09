package com.socialMediaPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socialMediaPlatform.entity.Post;
import com.socialMediaPlatform.entity.User;
import com.socialMediaPlatform.exception.PostException;
import com.socialMediaPlatform.exception.UserException;
import com.socialMediaPlatform.service.PostService;
import com.socialMediaPlatform.service.UserService;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

	@Autowired
	private UserService userService;

	@Autowired
	private PostService postService;

	/**
	 * taking the request from the user and returning the number of registered users.
	 */
	@GetMapping("/users")
	public ResponseEntity<Integer> getUserAnalyticsHandler() throws UserException {
		return new ResponseEntity<Integer>(userService.getUserAnalytics(), HttpStatus.OK);
	}

	/**
	 * taking the request from the user and returning the list of top 5 most active users.
	 */
	@GetMapping("/users/top-active")
	public ResponseEntity<List<User>> getUserAnalyticsTopActiveHandler() throws UserException {
		return new ResponseEntity<List<User>>(userService.getUserAnalyticsTopActive(), HttpStatus.OK);
	}

	/**
	 * taking the request from the user and returning the total number of posts.
	 */
	@GetMapping("/posts")
	public ResponseEntity<Integer> getPostAnalyticsHandler() throws PostException {
		return new ResponseEntity<Integer>(postService.getPostAnalytics(), HttpStatus.OK);
	}

	/**
	 * taking the request from the user and returning the list of top 5 most liked posts.
	 */
	@GetMapping("/posts/top-liked")
	public ResponseEntity<List<Post>> getPostAnalyticsTopLikedHandler() throws PostException {
		return new ResponseEntity<List<Post>>(postService.getPostAnalyticsTopLiked(), HttpStatus.OK);
	}

}

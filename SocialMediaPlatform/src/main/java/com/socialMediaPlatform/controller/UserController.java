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
import org.springframework.web.bind.annotation.RestController;

import com.socialMediaPlatform.entity.User;
import com.socialMediaPlatform.exception.UserException;
import com.socialMediaPlatform.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	/**
	 * userService : Dependency of UserService.
	 */
	@Autowired
	private UserService userService;

	/**
	 * taking the request from the user and registering user to the database by taking the data.
	 */
	@PostMapping
	public ResponseEntity<User> addUserHandler(@Valid @RequestBody User user) throws UserException {
		return new ResponseEntity<User>(userService.addUser(user), HttpStatus.CREATED);
	}

	/**
	 * taking the request from the user and returning user details of a specific id.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserHandler(@PathVariable Integer id) throws UserException {
		return new ResponseEntity<User>(userService.getUser(id), HttpStatus.OK);
	}

	/**
	 * taking the request from the user and returning updated user details of a specific id.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserHandler(@PathVariable Integer id, @Valid @RequestBody User user)
			throws UserException {
		return new ResponseEntity<User>(userService.updateUser(id, user), HttpStatus.ACCEPTED);
	}

	/**
	 * taking the request from the user and returning user details of a specific id after deleting from database.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUserHandler(@PathVariable Integer id) throws UserException {
		return new ResponseEntity<User>(userService.deleteUser(id), HttpStatus.ACCEPTED);
	}

}

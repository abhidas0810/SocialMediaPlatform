package com.socialMediaPlatform.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialMediaPlatform.entity.User;
import com.socialMediaPlatform.exception.UserException;
import com.socialMediaPlatform.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	/**
	 * userRepository : Dependency of UserRepository.
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Register a new user.
	 */
	@Override
	public User addUser(User user) throws UserException {
		if (user.getId() != null) {
			Optional<User> optionalUser = userRepository.findById(user.getId());
			if (optionalUser.isPresent()) {
				throw new UserException("User already exists with id: " + user.getId());
			}
		}
		return userRepository.save(user);
	}

	/**
	 * Retrieve the total number of users.
	 */
	@Override
	public Integer getUserAnalytics() throws UserException {
		Integer numberOfUsers = userRepository.findAll().size();
		if (numberOfUsers == 0) {
			throw new UserException("No user exists.");
		}
		return numberOfUsers;
	}

	/**
	 * Retrieve the top 5 most active users.
	 */
	@Override
	public List<User> getUserAnalyticsTopActive() throws UserException {
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			throw new UserException("No user exists.");
		}
		Collections.sort(users, (u1, u2) -> u2.getPosts().size() - u1.getPosts().size());
		List<User> topUsers = new ArrayList<>();
		int i = 0;
		for (User user : users) {
			if (i < 5) {
				topUsers.add(user);
			} else {
				break;
			}
			i++;
		}
		return topUsers;
	}

	/**
	 *  Fetch a specific user by id.
	 */
	@Override
	public User getUser(Integer id) throws UserException {
		return userRepository.findById(id).orElseThrow(() -> new UserException("User does not exists with id: " + id));
	}

	/**
	 * Update a user's name or bio.
	 */
	@Override
	public User updateUser(Integer id, User user) throws UserException {
		User registeredUser = userRepository.findById(id)
				.orElseThrow(() -> new UserException("User does not exists with id: " + id));
		if (registeredUser.getBio() != null) {
			registeredUser.setBio(user.getBio());
		}
		if (registeredUser.getName() != null) {
			registeredUser.setName(user.getName());
		}
		registeredUser.setUpdated_at(LocalDateTime.now());
		return userRepository.save(registeredUser);
	}

	/**
	 * Delete a user.
	 */
	@Override
	public User deleteUser(Integer id) throws UserException {
		User registeredUser = userRepository.findById(id)
				.orElseThrow(() -> new UserException("User does not exists with id: " + id));
		userRepository.delete(registeredUser);
		return registeredUser;
	}

}

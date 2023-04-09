package com.socialMediaPlatform.service;

import java.util.List;

import com.socialMediaPlatform.entity.User;
import com.socialMediaPlatform.exception.UserException;

public interface UserService {

	/**Create a new user.
	 * @param user : new user details.
	 * @return : newly created user for a particular user.
	 * @throws UserException : if user is already registered then UserException is thrown.
	 */
	public User addUser(User user) throws UserException;

	/**Retrieve the total number of users.
	 * @return : total number of users.
	 * @throws UserException : if no user is found then UserException is thrown.
	 */
	public Integer getUserAnalytics() throws UserException;

	/**Retrieve the top 5 most active users.
	 * @return : list of top 5 most active users.
	 * @throws UserException : if no user is found then UserException is thrown.
	 */
	public List<User> getUserAnalyticsTopActive() throws UserException;

	/**Retrieve a user by id.
	 * @param id : to find specific user details.
	 * @return : post by using id.
	 * @throws UserException : if user is not found for specific id then UserException is thrown.
	 */
	public User getUser(Integer id) throws UserException;

	/**Update a user's name or bio by id.
	 * @param id : to find specific user details.
	 * @param user : updated details of user.
	 * @return : updated details with existing user.
	 * @throws UserException : if user is not found for specific id then UserException is thrown.
	 */
	public User updateUser(Integer id, User user) throws UserException;

	/**Delete a user by id.
	 * @param id : to find specific user details.
	 * @return : details of deleted user.
	 * @throws UserException : if user is not found for specific id then UserException is thrown.
	 */
	public User deleteUser(Integer id) throws UserException;

}

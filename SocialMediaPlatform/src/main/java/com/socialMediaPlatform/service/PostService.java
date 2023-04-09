package com.socialMediaPlatform.service;

import java.util.List;

import com.socialMediaPlatform.entity.Post;
import com.socialMediaPlatform.exception.PostException;
import com.socialMediaPlatform.exception.UserException;

public interface PostService {

	/**Create a new post
	 * @param user_id : to find a specific user so that user can be added to the post.
	 * @param post : new post details.
	 * @return : newly created post for a particular user.
	 * @throws PostException : if post details is not saved in database then PostException is thrown.
	 * @throws UserException : if user is not registered for which post is trying to create then UserException is thrown.
	 */
	public Post addPost(Integer user_id, Post post) throws PostException, UserException;

	/**Retrieve the total number of posts.
	 * @return : total number of posts.
	 * @throws PostException : if no post is found then PostException is thrown.
	 */
	public Integer getPostAnalytics() throws PostException;

	/**Retrieve the top 5 most liked posts.
	 * @return : list of top 5 most liked posts.
	 * @throws PostException : if no post is found then PostException is thrown.
	 */
	public List<Post> getPostAnalyticsTopLiked() throws PostException;

	/**Retrieve a post by id.
	 * @param id : to find specific post details.
	 * @return : post by using id.
	 * @throws PostException : if post is not found for specific id then PostException is thrown.
	 */
	public Post getPost(Integer id) throws PostException;

	/**Update a post's content by id.
	 * @param id : to find specific post details.
	 * @param post : updated details of post.
	 * @return : updated details with existing post.
	 * @throws PostException : if no post is found to update then PostException is thrown.
	 */
	public Post updatePost(Integer id, Post post) throws PostException;

	/**Delete a post by id.
	 * @param id : to find specific post details.
	 * @return : details of deleted post.
	 * @throws PostException : if no post is found to delete then PostException is thrown.
	 */
	public Post deletePost(Integer id) throws PostException;

	/**Increment the like count of a post by id.
	 * @param id : to find specific post details.
	 * @return : details of liked post.
	 * @throws PostException
	 */
	public Post updatePostIncrementLike(Integer id) throws PostException;

	/**Decrement the like count of a post by id.
	 * @param id : to find specific post details.
	 * @return : details of disliked post.
	 * @throws PostException
	 */
	public Post updatePostDecrementLike(Integer id) throws PostException;

}

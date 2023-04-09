package com.socialMediaPlatform.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialMediaPlatform.entity.Post;
import com.socialMediaPlatform.entity.User;
import com.socialMediaPlatform.exception.PostException;
import com.socialMediaPlatform.exception.UserException;
import com.socialMediaPlatform.repository.PostRepository;
import com.socialMediaPlatform.repository.UserRepository;

@Service
public class PostServiceImpl implements PostService {

	/**
	 * postRepository : Dependency of PostRepository.
	 */
	@Autowired
	private PostRepository postRepository;

	/**
	 * userRepository : Dependency of UserRepository.
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Create a new post.
	 */
	@Override
	public Post addPost(Integer user_id, Post post) throws PostException, UserException {
		User registeredUser = userRepository.findById(user_id)
				.orElseThrow(() -> new UserException("User does not exists with id: " + user_id));
		if (post.getId() != null) {
			Optional<Post> optionalPost = postRepository.findById(post.getId());
			if (optionalPost.isPresent()) {
				throw new PostException("Post already exists with id: " + post.getId());
			}
		}
		registeredUser.getPosts().add(post);
		post.setUser(registeredUser);
		return postRepository.save(post);
	}

	/**
	 * Retrieve the total number of posts.
	 */
	@Override
	public Integer getPostAnalytics() throws PostException {
		Integer numberOfPost = postRepository.findAll().size();
		if (numberOfPost == 0) {
			throw new PostException("No post exists.");
		}
		return numberOfPost;
	}

	/**
	 * Retrieve the top 5 most liked posts.
	 */
	@Override
	public List<Post> getPostAnalyticsTopLiked() throws PostException {
		List<Post> posts = postRepository.findAll();
		if (posts.isEmpty()) {
			throw new PostException("No post exists.");
		}
		Collections.sort(posts, (p1, p2) -> p2.getLikes() - p1.getLikes());
		List<Post> topPosts = new ArrayList<>();
		int i = 0;
		for (Post post : posts) {
			if (i < 5) {
				topPosts.add(post);
			} else {
				break;
			}
			i++;
		}
		return topPosts;
	}

	/**
	 *  Fetch a specific post by id.
	 */
	@Override
	public Post getPost(Integer id) throws PostException {
		return postRepository.findById(id).orElseThrow(() -> new PostException("Post does not exists with id: " + id));
	}

	/**
	 * Update a post's content.
	 */
	@Override
	public Post updatePost(Integer id, Post post) throws PostException {
		Post registeredPost = postRepository.findById(id)
				.orElseThrow(() -> new PostException("Post does not exists with id: " + id));
		registeredPost.setContent(post.getContent());
		registeredPost.setUpdated_at(LocalDateTime.now());
		return postRepository.save(registeredPost);
	}

	/**
	 * Delete a post.
	 */
	@Override
	public Post deletePost(Integer id) throws PostException {
		Post registeredPost = postRepository.findById(id)
				.orElseThrow(() -> new PostException("Post does not exists with id: " + id));
		postRepository.delete(registeredPost);
		return registeredPost;
	}

	/**
	 * Like a post.
	 */
	@Override
	public Post updatePostIncrementLike(Integer id) throws PostException {
		Post registeredPost = postRepository.findById(id)
				.orElseThrow(() -> new PostException("Post does not exists with id: " + id));
		registeredPost.setLikes(registeredPost.getLikes() + 1);
		return postRepository.save(registeredPost);
	}

	/**
	 * Dislike a post.
	 */
	@Override
	public Post updatePostDecrementLike(Integer id) throws PostException {
		Post registeredPost = postRepository.findById(id)
				.orElseThrow(() -> new PostException("Post does not exists with id: " + id));
		if (registeredPost.getLikes() > 0) {
			registeredPost.setLikes(registeredPost.getLikes() - 1);
		} else {
			registeredPost.setLikes(0);
		}
		return postRepository.save(registeredPost);
	}

}

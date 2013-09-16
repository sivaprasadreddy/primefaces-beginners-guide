/**
 * 
 */
package com.packtpub.techbuzz.services;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Tag;

/**
 * @author skatam
 *
 */
public class PostServiceTest 
{
	
	private Logger logger = Logger.getLogger(getClass());
	
	private PostService postService;
	
	@Test
	public void testFindAllPosts()
	{
		List<Post> posts = postService.findAllPosts();
		assertNotNull(posts);
		for (Post post : posts)
		{
			assertNotNull(post);
			logger.debug(post);
		}		
	}
	
	@Test
	public void testFindPostsByUserId()
	{
		List<Post> posts = postService.findPostsByUserId(1);
		assertNotNull(posts);
		for (Post post : posts)
		{
			assertNotNull(post);
			logger.debug(post);
		}		
	}

	@Test
	public void testCreatePost()
	{
		Post post = new Post();
		post.setTitle("Sample Post");
		post.setDescription("Sample Post description");
		post.setUserId(1);
		post.setCreatedOn(new Date());
		post.addTag(new Tag(1));
		
		Post createdPost = postService.createPost(post);
		assertNotNull(createdPost);
		logger.debug("New Post Id: "+createdPost.getId());
	}

	@Test
	public void testGetPost()
	{
		Integer postId = 1;
		Post post =  postService.getPost(postId);
		assertNotNull(post);
		logger.debug(post);
	}

	@Test
	public void testUpdatePost()
	{
		Post post = new Post(1);
		post.setTitle("New Title :"+System.currentTimeMillis());
		post.setDescription("New Description :"+System.currentTimeMillis());
		postService.updatePost(post);
	}

	@Test
	public void testSearchPosts()
	{
		String query = "primefaces";
		List<Post> posts = postService.searchPosts(query);
		assertNotNull(posts);
		for (Post post : posts)
		{
			assertNotNull(post);
			logger.debug(post);
		}
	}
}

package com.packtpub.techbuzz.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.packtpub.techbuzz.entities.Post;

/**
 * @author Siva
 *
 */
@Stateless
public class PostService
{
	@PersistenceContext
	private EntityManager em;
	
	public Post createPost(Post post)
	{
		return null;
	}
	
	public List<Post> findAllPosts()
	{
		return null;
	}
	
	public List<Post> findPostsByUserId(Integer userId)
	{
		return null;
	}

	public Post getPost(Integer PostId)
	{
		return null;
	}

	public void updatePost(Post post){
		
	}
	
	public List<Post> searchPosts(String query){
		return null;
	}
	
}

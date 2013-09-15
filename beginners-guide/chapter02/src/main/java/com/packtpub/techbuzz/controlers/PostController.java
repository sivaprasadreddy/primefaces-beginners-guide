package com.packtpub.techbuzz.controlers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.services.BuzzService;

/**
 * @author Siva
 *
 */
@Component
@Scope("request")
public class PostController
{
	@Autowired
	private BuzzService buzzService;
	
	private List<Post> posts = null;
	
	private Post newPost = new Post();;
		
	@PostConstruct
	void init()
	{
		posts = buzzService.findAllPosts();
	}
	
	public List<Post> getPosts()
	{
		return posts;
	}
	public Post getNewPost()
	{
		return newPost;
	}
	public void setNewPost(Post newPost)
	{
		this.newPost = newPost;
	}

}

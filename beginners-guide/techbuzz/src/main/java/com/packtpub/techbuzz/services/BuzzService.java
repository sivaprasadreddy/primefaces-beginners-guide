package com.packtpub.techbuzz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.repositories.BuzzRepository;

/**
 * @author Siva
 *
 */
@Transactional
@Service
public class BuzzService
{
	@Autowired
	private BuzzRepository buzzRepository;

	public List<Post> findAllPosts()
	{
		return buzzRepository.findAllPosts();
	}
	
	public List<Post> findAllByPostedByUserId(Integer userId)
	{
		return buzzRepository.findPostsByUserId(userId);
	}

	public Post getPost(Integer PostId)
	{
		return buzzRepository.getPost(PostId);
	}

	public List<Tag> findByLabelStartingWith(String query)
	{
		return buzzRepository.findByLabelStartingWith(query);
	}

	public Post createPost(Post post)
	{
		return buzzRepository.createPost(post);
	}

	public List<Tag> findAllTags()
	{
		return buzzRepository.findAllTags();
	}
	
	/*
	public List<Post> getPosts()
	{
		return null;
	}
	
	public Post getPost(Integer postId){
		return null;
	}
	
	public Comment addComment(Comment comment){
		return null;
	}
	
	public void addUserRate(Vote vote){//TODO Its Rating not vote
		
	}
	
	public Post createPost(Post post){
		return null;
	}
	
	public Post updatePost(Post post){
		return null;
	}
	
	public List<Post> searchPosts(){
		return null;
	}
	*/
}

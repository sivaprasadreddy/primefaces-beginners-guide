package com.packtpub.techbuzz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.repositories.PostRepository;
import com.packtpub.techbuzz.repositories.TagRepository;
import com.packtpub.techbuzz.repositories.UserRepository;

/**
 * @author Siva
 *
 */
@Transactional
@Service
public class PostService
{
	@Autowired private UserRepository userRepository;
	@Autowired private PostRepository postRepository;
	@Autowired private TagRepository tagRepository;
	
	public Post createPost(Post post)
	{
		return postRepository.create(post);
	}
	
	public List<Post> findAllPosts()
	{
		return postRepository.findAll();
	}
	
	public List<Post> findAllByPostedByUserId(Integer userId)
	{
		return postRepository.findPostsByUserId(userId);
	}

	public Post getPost(Integer PostId)
	{
		return postRepository.findById(PostId);
	}

	public void updatePost(Post post){
		postRepository.update(post);
	}
	
	public List<Post> searchPosts(String query){
		return postRepository.searchPosts(query);
	}
	
}

package com.packtpub.techbuzz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.repositories.PostRepository;
import com.packtpub.techbuzz.repositories.TagRepository;

/**
 * @author Siva
 *
 */
@Transactional
@Service
public class BuzzService
{
	@Autowired private PostRepository postRepository;
	@Autowired private TagRepository tagRepository;
	
	public List<Post> findAllPosts()
	{
		return postRepository.findAllPosts();
	}
	
	public List<Post> findAllByPostedByUserId(Integer userId)
	{
		return postRepository.findPostsByUserId(userId);
	}

	public Post getPost(Integer PostId)
	{
		return postRepository.getPost(PostId);
	}

	public Post createPost(Post post)
	{
		Post createdPost = null;
		createdPost = postRepository.createPost(post);
		postRepository.insertPostTags(post.getId(), post.getTags());
		return createdPost;
	}

	public List<Tag> findByLabelStartingWith(String query)
	{
		return tagRepository.findByLabelStartingWith(query);
	}
	
	public List<Tag> findAllTags()
	{
		return tagRepository.findAllTags();
	}
	
}

package com.packtpub.techbuzz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Rating;
import com.packtpub.techbuzz.entities.Tag;
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
		 List<Post> posts = postRepository.findAll();
		if(posts != null)
		{
			for (Post post : posts)
			{
				this.populatePostTags(post);
			}
			this.populateUserRatings(posts);
		}
		return posts;
	}
	
	void populateUserRatings(List<Post> posts)
	{
		postRepository.populateUserRatings(posts);
	}
	
	private void populatePostTags(Post post)
	{
		List<Tag> tags = tagRepository.findPostTags(post.getId());
		post.setTags(tags);
	}

	public List<Post> findPostsByUserId(Integer userId)
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

	public List<Post> findPostsByTagLabel(String label)
	{
		List<Post> posts = postRepository.findPostsByTagLabel(label);
		for (Post post : posts)
		{
			this.populatePostTags(post);
		}
		
		return posts;
	}

	public void savePostRating(Rating rating)
	{
		postRepository.savePostRating(rating);
	}
	
}

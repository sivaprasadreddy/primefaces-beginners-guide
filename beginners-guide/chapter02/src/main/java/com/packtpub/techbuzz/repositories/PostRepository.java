package com.packtpub.techbuzz.repositories;

import java.util.List;

import com.packtpub.techbuzz.entities.Post;

/**
 * @author Siva
 *
 */
public interface PostRepository
{
	
	List<Post> findAllPosts();
	
	List<Post> findPostsByUserId(Integer userId);
	
	Post getPost(Integer PostId);

	Post createPost(Post post);
	
}

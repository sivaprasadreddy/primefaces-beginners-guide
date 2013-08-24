package com.packtpub.techbuzz.repositories;

import java.util.List;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Tag;

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
	
	boolean insertPostTags(Integer id, List<Tag> tags);
	
	List<Post> findPostsByTag(String label);
}

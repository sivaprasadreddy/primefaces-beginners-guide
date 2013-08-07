package com.packtpub.techbuzz.repositories;

import java.util.List;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Tag;

/**
 * @author Siva
 *
 */
public interface BuzzRepository
{
	
	List<Post> findAllPosts();
	
	List<Post> findPostsByUserId(Integer userId);
	
	//@Query("select l from Post l left join fetch l.votes where l.postId=?1")
	Post getPost(Integer PostId);

	//@Query("select t from Tag t where t.label like ?1")
	List<Tag> findByLabelStartingWith(String query);

	Post createPost(Post post);
	
	List<Tag> findAllTags();
}

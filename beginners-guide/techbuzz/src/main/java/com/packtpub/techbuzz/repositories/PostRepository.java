/**
 * 
 */
package com.packtpub.techbuzz.repositories;

import java.util.List;

import com.packtpub.techbuzz.entities.Post;

/**
 * @author skatam
 *
 */
public interface PostRepository extends GenericRepository<Integer, Post>
{

	public List<Post> findPostsByUserId(Integer userId);

	public List<Post> searchPosts(String query);
}

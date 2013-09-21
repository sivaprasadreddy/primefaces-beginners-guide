/**
 * 
 */
package com.packtpub.techbuzz.repositories;

import java.util.List;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Rating;

/**
 * @author skatam
 *
 */
public interface PostRepository extends GenericRepository<Integer, Post>
{

	public List<Post> findPostsByUserId(Integer userId);

	public List<Post> searchPosts(String query);

	public List<Post> findPostsByTagLabel(String label);

	public void populateUserRatings(List<Post> posts);

	public void savePostRating(Rating rating);
}

/**
 * 
 */
package com.packtpub.techbuzz.repositories.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.packtpub.techbuzz.entities.Post;

/**
 * @author skatam
 *
 */
public class PostRowMapper implements RowMapper<Post>
{

	@Override
	public Post mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Post post = new Post();
		post.setId(rs.getInt("post_id"));
		post.setTitle(rs.getString("title"));
		post.setDescription(rs.getString("description"));
		post.setUserId(rs.getInt("posted_by"));
		post.setCreatedOn(rs.getDate("created_on"));
		return post;
	}
	
}
package com.packtpub.techbuzz.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.repositories.PostRepository;

/**
 * @author Siva
 *
 */
@Repository
public class PostRepositoryImpl implements PostRepository
{
	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Post> findAllPosts()
	{
		return jdbcTemplate.query("select * from posts order by created_on desc", new PostMapper());
	}


	@Override
	public List<Post> findPostsByUserId(Integer userId)
	{
		String FIND_POSTS_BY_USER_SQL = "select * from posts where posted_by=? order by created_on desc";
		return jdbcTemplate.query(FIND_POSTS_BY_USER_SQL, 
				new Object[]{userId}, new PostMapper());
	}

	@Override
	public Post getPost(Integer postId)
	{
		String FIND_POST_SQL = "select * from posts where post_id=? order by created_on desc";
		List<Post> posts = jdbcTemplate.query(FIND_POST_SQL, 
					new Object[]{postId}, new PostMapper());
		if(posts != null && !posts.isEmpty())
		{
			return posts.get(0);
		}
		return null;
	}
	
	@Override
	public Post createPost(final Post post)
	{
		final String sql = "INSERT INTO POSTS (title, description, posted_by, created_on)"+
	 	 		" VALUES (?,?,?,?);";

		KeyHolder holder = new GeneratedKeyHolder();
		
		jdbcTemplate.update(new PreparedStatementCreator() {           
		    @Override
		    public PreparedStatement createPreparedStatement(Connection connection)
		            throws SQLException {
		        PreparedStatement ps = connection.prepareStatement(sql.toString(), Statement.RETURN_GENERATED_KEYS);
		        ps.setString(1, post.getTitle());
		        ps.setString(2, post.getDescription());
		        ps.setInt(3, post.getUserId());
		        if(post.getCreatedOn() != null)
                {
                	ps.setDate(4, new java.sql.Date(post.getCreatedOn().getTime()));
                }else {
                	ps.setDate(4, null);
                }
		        
		        return ps;
		    }
		}, holder);
		
		int newpostId = holder.getKey().intValue();
		post.setId(newpostId);
		return post;
	}

	

	@Override
	public boolean insertPostTags(Integer postId, List<Tag> tags) {
		
		if(tags == null || tags.isEmpty()){
			return true;
		}
		final String sql = "INSERT INTO POSTS_TAGS (post_id, tag_id) VALUES (?,?)";
		for (Tag tag : tags) {
			jdbcTemplate.update(sql, new Object[]{postId, tag.getId()});
		}
		
		return true;
	}
	
}

class PostMapper implements RowMapper<Post>{

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


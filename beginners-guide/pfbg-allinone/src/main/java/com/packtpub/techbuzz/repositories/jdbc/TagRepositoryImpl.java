package com.packtpub.techbuzz.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.repositories.TagRepository;
import com.packtpub.techbuzz.repositories.rowmappers.TagRowMapper;
import com.packtpub.techbuzz.web.view.TagPostCountBean;

/**
 * @author Siva
 *
 */
@Repository
public class TagRepositoryImpl implements TagRepository
{
	@Autowired 
	private JdbcTemplate jdbcTemplate;

	@Override
	public Tag create(final Tag tag) {
		final String INSERT_SQL = "INSERT INTO tags (label, value, description) VALUES (?, ?, ?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(
			    new PreparedStatementCreator() {
			        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
			            PreparedStatement ps =
			                connection.prepareStatement(INSERT_SQL, new String[] {"tag_id"});
			            	ps.setString(1, tag.getLabel());
			            	ps.setString(2, tag.getValue());
			            	ps.setString(3, tag.getDescription());
			            return ps;
			        }
			    },
			    keyHolder);

		Number key = keyHolder.getKey();
		tag.setId(key.intValue());
		return tag;
	}

	@Override
	public Tag findById(Integer tagId) {
		String FIND_TAG_SQL = "select * from tags where tag_id=?";
		List<Tag> tags = jdbcTemplate.query(FIND_TAG_SQL, 
					new Object[]{tagId}, new TagRowMapper());
		if(tags != null && !tags.isEmpty())
		{
			return tags.get(0);
		}
		return null;
	}

	@Override
	public List<Tag> findAll() {
		String FIND_ALL_TAGS_SQL = "select * from tags";
		return jdbcTemplate.query(FIND_ALL_TAGS_SQL, new TagRowMapper());
	}

	@Override
	public void update(Tag tag) {
		String UPDATE_SQL = "UPDATE tags SET label = ?, value = ?, description=? WHERE tag_id = ?";
		jdbcTemplate.update(UPDATE_SQL, 
						new Object[]{tag.getLabel(), 
									tag.getValue(),
									tag.getDescription(), 
									tag.getId()});
	}

	@Override
	public void delete(Integer tagId) {
		String DELETE_SQL = "delete from tags where tag_id=?";
		jdbcTemplate.update(DELETE_SQL, new Object[]{tagId});
	}

	@Override
	public List<Tag> findByLabelStartingWith(String query) {
		String FIND_ALL_TAGS_SQL = "select * from tags where label like ?";
		return jdbcTemplate.query(FIND_ALL_TAGS_SQL, new Object[]{query+"%"}, new TagRowMapper());
	}

	@Override
	public List<TagPostCountBean> getTagPostCounts()
	{
		String SQL = "SELECT t.label, count(*) posts_count FROM posts_tags p left outer join tags t on p.tag_id=t.tag_id group by p.tag_id";
		return jdbcTemplate.query(SQL, new RowMapper<TagPostCountBean>(){

			@Override
			public TagPostCountBean mapRow(ResultSet rs, int rowNum) throws SQLException
			{
				TagPostCountBean bean = new TagPostCountBean();
				bean.setTag(rs.getString("label"));
				bean.setPostCount(rs.getInt("posts_count"));
				
				return bean;
			}
			
		});
	}

	@Override
	public List<Tag> findPostTags(Integer postId)
	{
		String FIND_ALL_TAGS_SQL = "SELECT t.*  FROM posts_tags p left outer join tags t on p.tag_id=t.tag_id where p.post_id=?";
		return jdbcTemplate.query(FIND_ALL_TAGS_SQL, new Object[]{postId}, new TagRowMapper());
	}

	
	
}



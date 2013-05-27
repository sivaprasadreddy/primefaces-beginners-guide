package com.packtpub.techbuzz.repositories.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.repositories.TagRepository;

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
	public List<Tag> findByLabelStartingWith(String query)
	{
		String sql = "SELECT TAG_ID, LABEL, VALUE, DESCRIPTION FROM TAGS WHERE label like ?";
		return jdbcTemplate.query(sql , new Object[]{query+"%"}, new TagMapper());
	}


	@Override
	public List<Tag> findAllTags()
	{
		String sql = "SELECT TAG_ID, LABEL, VALUE, DESCRIPTION FROM TAGS";
		return jdbcTemplate.query(sql , new TagMapper());
	}
	
}

class TagMapper implements RowMapper<Tag>{

	@Override
	public Tag mapRow(ResultSet rs, int rowNum) throws SQLException
	{
		Tag tag = new Tag();
		tag.setId(rs.getInt("tag_id"));
		tag.setLabel(rs.getString("label"));
		tag.setValue(rs.getString("value"));
		tag.setDescription(rs.getString("description"));
		return tag;
	}
	
}
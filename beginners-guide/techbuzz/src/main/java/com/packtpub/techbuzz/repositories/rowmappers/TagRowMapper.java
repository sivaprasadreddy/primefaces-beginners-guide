/**
 * 
 */
package com.packtpub.techbuzz.repositories.rowmappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.packtpub.techbuzz.entities.Tag;

/**
 * @author skatam
 *
 */
public class TagRowMapper implements RowMapper<Tag>
{

	@Override
	public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
		Tag tag = new Tag();
		//TODO
		return tag;
	}

}

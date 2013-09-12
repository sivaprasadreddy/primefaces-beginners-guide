package com.packtpub.techbuzz.repositories.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	public Tag create(Tag t) {
		return null;
	}

	@Override
	public Tag findById(Integer key) {
		return null;
	}

	@Override
	public List<Tag> findAll() {
		return null;
	}

	@Override
	public void update(Tag t) {
		
	}

	@Override
	public void delete(Integer key) {
		
	}

	@Override
	public List<Tag> findByLabelStartingWith(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}



package com.packtpub.techbuzz.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.packtpub.techbuzz.entities.Tag;

/**
 * @author Siva
 *
 */
@Stateless
public class TagService
{
	@PersistenceContext
	private EntityManager em;

	public Tag createTag(Tag tag)
	{
		return null;
	}

	public Tag findTagById(Integer tagId)
	{
		return null;
	}

	public List<Tag> findAllTags()
	{
		return null;
	}

	public void updateTag(Tag tag)
	{
		
	}

	public void deleteTag(Integer tagId)
	{
		
	}

	public List<Tag> findByLabelStartingWith(String query)
	{
		return null;
	}

	
}

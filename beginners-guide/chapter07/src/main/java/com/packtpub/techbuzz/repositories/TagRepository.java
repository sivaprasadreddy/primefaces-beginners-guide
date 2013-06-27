package com.packtpub.techbuzz.repositories;

import java.util.List;

import com.packtpub.techbuzz.entities.Tag;

/**
 * @author Siva
 *
 */
public interface TagRepository
{
	List<Tag> findByLabelStartingWith(String query);

	List<Tag> findAllTags();
}

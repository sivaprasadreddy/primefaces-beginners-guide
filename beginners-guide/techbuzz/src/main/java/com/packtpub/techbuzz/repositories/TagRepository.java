/**
 * 
 */
package com.packtpub.techbuzz.repositories;

import java.util.List;

import com.packtpub.techbuzz.entities.Tag;

/**
 * @author skatam
 *
 */
public interface TagRepository extends GenericRepository<Integer, Tag>
{

	List<Tag> findByLabelStartingWith(String query);

}

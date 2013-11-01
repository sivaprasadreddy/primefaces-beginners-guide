/**
 * 
 */
package com.packtpub.techbuzz.repositories;

import java.util.List;

import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.web.view.TagPostCountBean;

/**
 * @author skatam
 *
 */
public interface TagRepository extends GenericRepository<Integer, Tag>
{

	List<Tag> findByLabelStartingWith(String query);

	List<TagPostCountBean> getTagPostCounts();

	List<Tag> findPostTags(Integer id);

}

package com.packtpub.techbuzz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.repositories.PostRepository;
import com.packtpub.techbuzz.repositories.TagRepository;
import com.packtpub.techbuzz.repositories.UserRepository;
import com.packtpub.techbuzz.web.view.TagPostCountBean;

/**
 * @author Siva
 *
 */
@Transactional
@Service
public class TagService
{
	@Autowired private UserRepository userRepository;
	@Autowired private PostRepository postRepository;
	@Autowired private TagRepository tagRepository;

	public Tag createTag(Tag tag)
	{
		return tagRepository.create(tag);
	}

	public Tag findTagById(Integer tagId)
	{
		return tagRepository.findById(tagId);
	}

	public List<Tag> findAllTags()
	{
		return tagRepository.findAll();
	}

	public void updateTag(Tag tag)
	{
		tagRepository.update(tag);
	}

	public void deleteTag(Integer tagId)
	{
		tagRepository.delete(tagId);
	}

	public List<Tag> findByLabelStartingWith(String query)
	{
		return tagRepository.findByLabelStartingWith(query);
	}

	public List<TagPostCountBean> getTagPostCounts()
	{
		return tagRepository.getTagPostCounts();
	}

	
}

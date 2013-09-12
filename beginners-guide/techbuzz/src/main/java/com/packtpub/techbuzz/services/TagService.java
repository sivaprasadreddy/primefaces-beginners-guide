package com.packtpub.techbuzz.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.repositories.PostRepository;
import com.packtpub.techbuzz.repositories.TagRepository;
import com.packtpub.techbuzz.repositories.UserRepository;

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

	public List<Tag> findByLabelStartingWith(String query)
	{
		return tagRepository.findByLabelStartingWith(query);
	}

	public List<Tag> findAllTags()
	{
		return tagRepository.findAll();
	}
	
}

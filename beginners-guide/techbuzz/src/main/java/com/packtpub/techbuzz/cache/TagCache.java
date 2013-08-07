package com.packtpub.techbuzz.cache;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.repositories.BuzzRepository;

/**
 * @author Siva
 *
 */
@Component
public class TagCache
{
	private static TagCache tagCache = null;
	
	@Autowired
	private BuzzRepository buzzRepository;
	
	private List<Tag> tags = null;
	
	@PostConstruct
	void init()
	{
		tags = buzzRepository.findAllTags();
		tagCache = this;
	}
	
	public static TagCache getTagCache()
	{
		return tagCache;
	}
	public List<Tag> getTags()
	{
		return tags;
	}
}

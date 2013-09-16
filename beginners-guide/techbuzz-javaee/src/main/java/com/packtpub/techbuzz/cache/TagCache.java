package com.packtpub.techbuzz.cache;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.packtpub.techbuzz.entities.Tag;

//@Stateless
//@Singleton
public class TagCache
{
	//@PersistenceContext
	private EntityManager em;
	
	private List<Tag> tags;
	
	//@PostConstruct
	public void init()
	{
		tags = new ArrayList<Tag>();
		try
		{
			List<Tag> resultList = em.createQuery("select t from Tag t", Tag.class).getResultList();
			tags.addAll(resultList);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public List<Tag> getTags()
	{
		return tags;
	}

}

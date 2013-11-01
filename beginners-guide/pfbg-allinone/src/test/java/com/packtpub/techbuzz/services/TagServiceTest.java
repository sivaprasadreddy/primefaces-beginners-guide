/**
 * 
 */
package com.packtpub.techbuzz.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.packtpub.techbuzz.config.AppConfig;
import com.packtpub.techbuzz.entities.Tag;

/**
 * @author skatam
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AppConfig.class)
public class TagServiceTest 
{
	private Logger logger = Logger.getLogger(getClass());
	
	@Autowired private TagService tagService;
	
	@Test
	public void createTag()
	{
		logger.debug("----------------createTag -----------------");
		Tag tag = new Tag();
		tag.setLabel("Sivalabs");
		tag.setValue("sivalabs");
		tag.setDescription("SivaLabs Blog");
		Tag createdTag = tagService.createTag(tag);
		assertNotNull(createdTag);
		logger.debug(createdTag);
	}
	@Test
	public void findTagById()
	{
		logger.debug("----------------findTagById -----------------");
		Integer tagId =1;
		Tag tag = tagService.findTagById(tagId);
		assertNotNull(tag);
		logger.debug(tag);
	}
	@Test
	public void updateTag()
	{
		logger.debug("----------------updateTag -----------------");
		Integer tagId = 1;
		Tag tag = new Tag(tagId);
		tag.setLabel("Sivalabs:"+System.currentTimeMillis());
		tag.setValue("sivalabs:"+System.currentTimeMillis());
		tag.setDescription("SivaLabs Blog:"+System.currentTimeMillis());
		tagService.updateTag(tag);
		tag = tagService.findTagById(tagId);
		assertNotNull(tag);
		logger.debug(tag);
	}
	@Test
	public void deleteTag()
	{
		logger.debug("----------------deleteTag -----------------");
		Integer tagId = 1;
		tagService.deleteTag(tagId);
		Tag tag = tagService.findTagById(tagId);
		assertNull(tag);
	}

	@Test
	public void testFindAllTags()
	{
		logger.debug("----------------testFindAllTags -----------------");
		List<Tag> tags = tagService.findAllTags();
		assertNotNull(tags);
		for (Tag tag : tags)
		{
			assertNotNull(tag);
			logger.debug(tag);
		}
	}
	
	@Test
	public void testFindByLabelStartingWith()
	{
		logger.debug("----------------testFindByLabelStartingWith -----------------");
		String query = "p";
		List<Tag> tags = tagService.findByLabelStartingWith(query );
		assertNotNull(tags);
		for (Tag tag : tags)
		{
			assertNotNull(tag);
			logger.debug(tag);
		}
	}

}

package com.packtpub.techbuzz.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.services.BuzzService;

/**
 * @author Siva
 *
 */
@Component
@Scope("request")
public class TagController
{
	@Autowired
	private BuzzService buzzService;
	
	private List<Tag> tags = null;
	private List<Tag> selectedTags = new ArrayList<Tag>();
	private Tag selectedTag = new Tag();
	
		
	@PostConstruct
	void init()
	{
		tags = buzzService.findAllTags();
	}
	
	public void setSelectedTag(Tag selectedTag)
	{
		this.selectedTag = selectedTag;
	}
	public Tag getSelectedTag()
	{
		return selectedTag;
	}
	
	public List<Tag> getTags()
	{
		return tags;
	}
	public List<Tag> getSelectedTags()
	{
		return selectedTags;
	}
	public void setSelectedTags(List<Tag> selectedTags)
	{
		this.selectedTags = selectedTags;
	}
	
	public List<Tag> completeTag(String query)
	{
		if(query == null){
			return new ArrayList<Tag>();
		}
		List<Tag> tags = new ArrayList<Tag>();
		List<Tag> allTags = buzzService.findAllTags();
		for (Tag tag : allTags)
		{
			if(tag.getLabel().toLowerCase().startsWith(query.toLowerCase())){
				tags.add(tag);
			}
		}
		return tags;
	}
	
	public void handleTagSelected(SelectEvent selectEvent)
	{
		Tag selectedObj = (Tag) selectEvent.getObject();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You have selected :"+selectedObj.getLabel()));
	}
	
	public void handleTagUnselected(UnselectEvent unselectEvent)
	{
		Tag unselectedObj = (Tag) unselectEvent.getObject();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You have unselected :"+unselectedObj.getLabel()));
	}
	
}

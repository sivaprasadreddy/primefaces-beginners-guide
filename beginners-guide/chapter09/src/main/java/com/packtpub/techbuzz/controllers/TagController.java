package com.packtpub.techbuzz.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.Post;
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
	
	private static Random random = new Random();
	private TagCloudModel model; 
	private List<Post> posts;
	
		
	@PostConstruct
	void init()
	{
		tags = buzzService.findAllTags();
		
		model = new DefaultTagCloudModel();  
        posts = buzzService.findAllPosts();
        for (Tag tag : tags)
		{
        	model.addTag(new DefaultTagCloudItem(tag.getLabel(), getStrength(1, 5)));
		}
        
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
	
	public TagCloudModel getModel() {  
        return model;  
    }  
      
    public void onSelect(SelectEvent event) {  
        TagCloudItem item = (TagCloudItem) event.getObject();  
        String label = item.getLabel();
        FacesMessage msg = new FacesMessage("Selected Tag: "+ item.getLabel());  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        posts = buzzService.findPostsByTag(label);
    }
    
    public List<Post> getPosts()
	{
		return posts;
	}
    private int getStrength(int low, int high)
	{
    	return random.nextInt(high-low) + low;
	}
	
}

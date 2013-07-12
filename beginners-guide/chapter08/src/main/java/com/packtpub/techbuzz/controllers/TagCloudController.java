package com.packtpub.techbuzz.controllers;

import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
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
 * @author K. Siva Prasad Reddy
 * Date : 10-Jul-2013
 */
@Component
@Scope("request")
public class TagCloudController
{
	@Autowired
	private BuzzService buzzService;
	
	private static Random random = new Random();
	private TagCloudModel model; 
	private List<Post> posts;
	
	@PostConstruct
	void init() 
	{  
        model = new DefaultTagCloudModel();  
        posts = buzzService.findAllPosts();
        List<Tag> tags = buzzService.findAllTags();
        int max = tags.size();
        for (Tag tag : tags)
		{
        	model.addTag(new DefaultTagCloudItem(tag.getLabel(), getStrength(1, max)));
		}
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

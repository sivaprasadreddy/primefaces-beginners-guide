package com.packtpub.techbuzz.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.services.PostService;
import com.packtpub.techbuzz.services.TagService;
import com.packtpub.techbuzz.utils.JSFUtils;

/**
 * @author Siva
 *
 */
@Component
@Scope("request")
public class PostController implements Serializable 
{
	private static final long serialVersionUID = 1L;
	@Autowired private PostService postService;
	@Autowired private TagService tagService;
	
	
	private List<Tag> tags = null;
	private List<Tag> selectedTags = new ArrayList<Tag>();
	
	private Post newPost = new Post();
		
	@PostConstruct
	void init()
	{
		tags = tagService.findAllTags();
	}
	
	public Post getNewPost()
	{
		return newPost;
	}
	public void setNewPost(Post newPost)
	{
		this.newPost = newPost;
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
		List<Tag> allTags = tagService.findAllTags();
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
		Integer tagid = selectedObj.getId();
		Tag duplicateTag = null;
		int count = 0;
		List<Tag> newPostTags = newPost.getTags();
		for(Tag t : newPostTags)
		{
			if(tagid == t.getId()){
				duplicateTag = t;
				count++;
			}
		}
		if(count > 1)
		{
			newPostTags.remove(duplicateTag);
			RequestContext.getCurrentInstance().update("newPostForm:newPostTags");
			JSFUtils.addErrorMsg("You have selected Duplicate Tag:"+selectedObj.getLabel());
		}
		else
		{
			JSFUtils.addInfoMsg("You have selected :"+selectedObj.getLabel());
		}
	}
	
	public void handleTagUnselected(UnselectEvent unselectEvent)
	{
		Tag unselectedObj = (Tag) unselectEvent.getObject();
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("You have unselected :"+unselectedObj.getLabel()));
	}
	
	
	public String createPost()
	{
		String view = null;
		User loggedinUser = JSFUtils.getLoggedinUser();
		newPost.setUserId(loggedinUser.getId());
		newPost.setTags(selectedTags);
		try {
			postService.createPost(newPost);
			JSFUtils.addInfoMsg("Post created successfully");
			newPost = new Post();
			view = "home.jsf?faces-redirect=true";
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtils.addErrorMsg("Failed to save post. Error: "+e.getMessage());
		}
		return view;
	}
}

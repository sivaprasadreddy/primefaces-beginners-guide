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

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.services.BuzzService;
import com.packtpub.techbuzz.utils.JSFUtils;

/**
 * @author Siva
 *
 */
@Component
@Scope("request")
public class PostController
{
	@Autowired
	private BuzzService buzzService;
	
	private List<Post> posts = null;
	private List<Tag> tags = null;
	private List<Tag> selectedTags = new ArrayList<Tag>();
	private Tag selectedTag = new Tag();
	
	private Post newPost = new Post();;
		
	@PostConstruct
	void init()
	{
		posts = buzzService.findAllPosts();
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
	public List<Post> getPosts()
	{
		return posts;
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
	
	
	public void createPost()
	{
		User loggedinUser = JSFUtils.getLoggedinUser();
		newPost.setUserId(loggedinUser.getId());
		try {
			buzzService.createPost(newPost);
			JSFUtils.addInfoMsg("Post created successfully");
			newPost = new Post();
		} catch (Exception e) {
			e.printStackTrace();
			JSFUtils.addErrorMsg("Failed to save post. Error: "+e.getMessage());
		}

	}
}

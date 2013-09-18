/**
 * 
 */
package com.packtpub.techbuzz.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.entities.User;
import com.packtpub.techbuzz.services.PostService;
import com.packtpub.techbuzz.services.TagService;
import com.packtpub.techbuzz.services.UserService;
import com.packtpub.techbuzz.utils.JSFUtils;

/**
 * @author skatam
 *
 */
@Component
@Scope("view")
public class AdminController implements Serializable 
{
	private static final long serialVersionUID = 1L;
	private transient UserService userService;
	private transient TagService tagService;
	private transient PostService postService;
	
	private List<User> users = null;
	private List<Tag> tags = null;
	private List<Post> posts = null;
	private Tag newTag;
	
	private List<User> selectedUsers = new ArrayList<User>();
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	@Autowired
	public void setPostService(PostService postService) {
		this.postService = postService;
	}
	@Autowired
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
	
	@PostConstruct
	public void init()
	{
		this.users = userService.findAllUsers();
		this.tags = tagService.findAllTags();
		//this.posts = postService.findAllPosts();
	}
	
	public List<User> getUsers() {
		return users;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public List<Tag> getTags() {
		return tags;
	}
	public List<User> getSelectedUsers() {
		if(selectedUsers == null){
			selectedUsers = new ArrayList<User>();
		}
		return selectedUsers;
	}
	public void setSelectedUsers(List<User> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}
	public Tag getNewTag() {
		if(newTag == null){
			newTag = new Tag();
		}
		return newTag;
	}
	public void setNewTag(Tag newTag) {
		this.newTag = newTag;
	}
	
	public void disableUsers()
	{
		if(selectedUsers ==null || selectedUsers.isEmpty()){
			JSFUtils.addInfoMsg("No users selected.");
			return;
		}
		for (User user : selectedUsers) 
		{
			System.out.println("Disabling "+user.getEmailId());
		}
		this.userService.disableUsers(selectedUsers);
		JSFUtils.addInfoMsg("Disabled successfully");
		selectedUsers = new ArrayList<User>();
		this.users = userService.findAllUsers();
	}
	
	public void enableUsers()
	{
		if(selectedUsers ==null || selectedUsers.isEmpty()){
			JSFUtils.addInfoMsg("No users selected.");
			return;
		}
		for (User user : selectedUsers) 
		{
			System.out.println("Enabling "+user.getEmailId());
		}
		this.userService.enableUsers(selectedUsers);
		JSFUtils.addInfoMsg("Enabled successfully");
		selectedUsers = new ArrayList<User>();
		this.users = userService.findAllUsers();
	}
	
	public void createTag() {
		this.tagService.createTag(newTag);
		JSFUtils.addInfoMsg("Tag created successfully");
		newTag = null;
		this.tags = tagService.findAllTags();
	}
}

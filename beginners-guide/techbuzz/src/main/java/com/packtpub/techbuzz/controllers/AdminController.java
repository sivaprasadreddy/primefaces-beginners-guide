/**
 * 
 */
package com.packtpub.techbuzz.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Role;
import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.entities.User;
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
	
	private List<User> users = null;
	private List<Role> roles = null;
	private List<Tag> tags = null;
	private List<Post> posts = null;
	private Tag newTag;
	
	private List<User> selectedUsers = new ArrayList<User>();
	private User selectedUser = null;
	private DualListModel<Role> selectedUserRoles;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	public void setTagService(TagService tagService) {
		this.tagService = tagService;
	}
	
	@PostConstruct
	public void init()
	{
		this.users = userService.findAllUsers();
		this.roles = userService.findAllRoles();
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
	
	public User getSelectedUser()
	{
		return selectedUser;
	}
	public void setSelectedUser(User selectedUser)
	{
		this.selectedUser = selectedUser;
		List<Role> source = new ArrayList<Role>();
		List<Role> target = new ArrayList<Role>();
		
		for (Role role : roles)
		{
			if(selectedUser.getRoles().contains(role)){
				target.add(role);
			} else {
				source.add(role);
			}
			
		}
		selectedUserRoles = new DualListModel<Role>(source, target);
	}
	public DualListModel<Role> getSelectedUserRoles()
	{
		
		if(selectedUserRoles == null){
			selectedUserRoles = new DualListModel<Role>();
		}
		return selectedUserRoles;
	}
	public void setSelectedUserRoles(DualListModel<Role> selectedUserRoles)
	{
		this.selectedUserRoles = selectedUserRoles;
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
	
	public void updateUser()
	{
		
		if(selectedUser != null){
			List<Role> updatedRoles = selectedUserRoles.getTarget();
			selectedUser.setRoles(updatedRoles);
			userService.updateUserRoles(selectedUser);
			JSFUtils.addInfoMsg("Updated successfully");
		}
		selectedUsers = new ArrayList<User>();
		this.users = userService.findAllUsers();
	}
	
	public void onTagEdit(RowEditEvent event) {  
		Tag tag = (Tag) event.getObject();
		tagService.updateTag(tag);
		JSFUtils.addInfoMsg("Tag saved successfully");
    }
}

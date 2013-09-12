package com.packtpub.techbuzz.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.services.PostService;
import com.packtpub.techbuzz.services.TagService;
import com.packtpub.techbuzz.utils.JSFUtils;

/**
 * @author Siva
 *
 */
@Component
@Scope("request")
public class BuzzController
{
	@Autowired private PostService postService;
	@Autowired private TagService tagService;
	
	private List<Post> posts = null;
	private List<Tag> tags = null;
	private List<Tag> selectedTags = null;
	private Tag selectedTag = null;
	
	private Post newPost = null;
	public BuzzController()
	{
		newPost = new Post();
	}
	
	@PostConstruct
	void init()
	{
		posts = postService.findAllPosts();
		tags = tagService.findAllTags();
		selectedTags = new ArrayList<Tag>();
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
		if(selectedTags == null){
			selectedTags = new ArrayList<Tag>();
		}
		return selectedTags;
	}
	public void setSelectedTags(List<Tag> selectedTags)
	{
		this.selectedTags = selectedTags;
	}
	
	/*public List<Tag> completeTag(String query)
	{
		System.out.println("completeTag-------------->"+query);
		if(query == null){
			return new ArrayList<Tag>();
		}
		List<Tag> tags = new ArrayList<Tag>();
		List<Tag> allTags = TagRepository.getTags();
		System.out.println("---->"+allTags);
		for (Tag tag : allTags)
		{
			if(tag.getLabel().toLowerCase().startsWith(query.toLowerCase())){
				tags.add(tag);
			}
		}
		return tags;
	}
	*/
	public List<Tag> completeTags(String query)
	{
		System.out.println("completeTags-------------->"+query);
		if(query == null){
			return new ArrayList<Tag>();
		}
		List<Tag> tags = new ArrayList<Tag>();
		List<Tag> allTags = tagService.findAllTags();
		System.out.println("---->"+allTags);
		for (Tag tag : allTags)
		{
			if(tag.getLabel().toLowerCase().startsWith(query.toLowerCase())){
				tags.add(tag);
			}
		}
		return tags;
	}
	
	public void createPost()
	{
		System.out.println("#################################################");
		newPost.setUserId(1);
		postService.createPost(newPost);
		JSFUtils.addInfoMsg("Post created successfully");

	}
}

package com.packtpub.techbuzz.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

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
//@ManagedBean
//@RequestScoped
@Component
@Scope("request")
public class BuzzController
{
	@Autowired
	private BuzzService buzzService;
	
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
		/*posts = new ArrayList<Post>();
		posts.add(new Post(1, "Apple Can't Obey Its Own Specifications", "It turns out that iTunes (at least 11.0.2 build 26) doesn’t actually implement Apple’s own specification properly, in that it can’t handle media segment URIs relative to the URI of the m3u8 playlist."));
		posts.add(new Post(2, "5 Ways to Implement HTTPS in an Insufficient Manner (and Leak Sensitive Data)", "HTTPS or SSL or TLS or whatever you want to call it can be a confusing beast. Some say it’s just about protecting your password and banking info whilst the packets are flying around the web but I’ve long said that SSL is not about encryption."));
		posts.add(new Post(3, "Getting Started with JSON-P", "For those unaware, JSON-P is now in the proposed final draft stage. Do feel free to download the draft and take a look at it yourself."));
		posts.add(new Post(4, "Testing Frontend integration with Play 2.x (Scala)", "In this blog, I will demonstrate how we implement a simple test to test the Web layer using TestServer."));
		posts.add(new Post(5, "Augmenting 3rd-Party Libraries", "For every project I’ve participated in, there has been a need for augmenting some third-party library. There are a few of reasons for this"));
		
		
		posts.add(new Post(1, "Apple Can't Obey Its Own Specifications", "It turns out that iTunes (at least 11.0.2 build 26) doesn’t actually implement Apple’s own specification properly, in that it can’t handle media segment URIs relative to the URI of the m3u8 playlist."));
		posts.add(new Post(2, "5 Ways to Implement HTTPS in an Insufficient Manner (and Leak Sensitive Data)", "HTTPS or SSL or TLS or whatever you want to call it can be a confusing beast. Some say it’s just about protecting your password and banking info whilst the packets are flying around the web but I’ve long said that SSL is not about encryption."));
		posts.add(new Post(3, "Getting Started with JSON-P", "For those unaware, JSON-P is now in the proposed final draft stage. Do feel free to download the draft and take a look at it yourself."));
		posts.add(new Post(4, "Testing Frontend integration with Play 2.x (Scala)", "In this blog, I will demonstrate how we implement a simple test to test the Web layer using TestServer."));
		posts.add(new Post(5, "Augmenting 3rd-Party Libraries", "For every project I’ve participated in, there has been a need for augmenting some third-party library. There are a few of reasons for this"));
		*/
		
		posts = buzzService.findAllPosts();
		tags = buzzService.findAllTags();
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
		List<Tag> allTags = buzzService.findAllTags();
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
		newPost.setPostedBy(new User(1));
		buzzService.createPost(newPost);
		JSFUtils.addInfoMsg("Post created successfully");

	}
}

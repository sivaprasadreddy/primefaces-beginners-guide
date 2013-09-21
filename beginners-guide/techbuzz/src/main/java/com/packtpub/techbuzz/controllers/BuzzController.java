package com.packtpub.techbuzz.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.event.RateEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.tagcloud.DefaultTagCloudItem;
import org.primefaces.model.tagcloud.DefaultTagCloudModel;
import org.primefaces.model.tagcloud.TagCloudItem;
import org.primefaces.model.tagcloud.TagCloudModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Rating;
import com.packtpub.techbuzz.entities.Tag;
import com.packtpub.techbuzz.services.PostService;
import com.packtpub.techbuzz.services.TagService;
import com.packtpub.techbuzz.utils.JSFUtils;
import com.packtpub.techbuzz.web.view.PostView;

/**
 * @author Siva
 *
 */
@Component
@Scope("view")
public class BuzzController
{
	@Autowired private PostService postService;
	@Autowired private TagService tagService;
	
	private List<Post> posts = null;
	private List<PostView> postViews = null;
	private List<Tag> tags = null;
	private List<Tag> selectedTags = null;
	private Tag selectedTag = new Tag();
	private PostView selectedPostView;
	
	private static Random random = new Random();
	private TagCloudModel model;
	
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
		
		initPostViews();
		model = new DefaultTagCloudModel();  
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
	public void initPostViews()
	{
		List<PostView> views = new ArrayList<PostView>();
		if(posts != null && !posts.isEmpty())
		{
			for (Post post : posts)
			{
				PostView postView = new PostView(post, JSFUtils.getLoggedinUser(), null);
				views.add(postView);
			}
		}
		this.postViews = views;
	}
	public List<PostView> getPostViews()
	{
		return postViews;
	}
	public PostView getSelectedPostView()
	{
		if(selectedPostView == null){
			selectedPostView = new PostView();
		}
		return selectedPostView;
	}
	public void setSelectedPostView(PostView selectedPostView)
	{
		this.selectedPostView = selectedPostView;
	}
	
	public void handlePostRating(RateEvent rateEvent) {  
		int rate = ((Integer) rateEvent.getRating()).intValue();
		Rating rating = new  Rating();
		rating.setPostId(selectedPostView.getPost().getId());
		rating.setUserId(selectedPostView.getLoginUser().getId());
		rating.setRate(rate);
		postService.savePostRating(rating);
		JSFUtils.addInfoMsg("You rated:" +rate);
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
	
	public void createPost()
	{
		System.out.println("#################################################");
		newPost.setUserId(1);
		postService.createPost(newPost);
		JSFUtils.addInfoMsg("Post created successfully");

	}
	public TagCloudModel getModel() {  
        return model;  
    }  
      
    public void onSelect(SelectEvent event) {  
        TagCloudItem item = (TagCloudItem) event.getObject();  
        String label = item.getLabel();
        FacesMessage msg = new FacesMessage("Selected Tag: "+ item.getLabel());  
        FacesContext.getCurrentInstance().addMessage(null, msg);
        posts = postService.findPostsByTagLabel(label);
        initPostViews();
    }
	private int getStrength(int low, int high)
	{
    	return random.nextInt(high-low) + low;
	}
}

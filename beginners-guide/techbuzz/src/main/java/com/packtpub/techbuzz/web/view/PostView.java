package com.packtpub.techbuzz.web.view;

import com.packtpub.techbuzz.entities.Post;
import com.packtpub.techbuzz.entities.Rating;
import com.packtpub.techbuzz.entities.User;

/**
 * @author K. Siva Prasad Reddy
 * Date : 21-Sep-2013
 */
public class PostView
{
	private Post post;
	private User loginUser;
	private Rating rating;
	
	public PostView()
	{
	}
	public PostView(Post post, User loginUser)
	{
		this.post = post;
		this.loginUser = loginUser;
	}
	public PostView(Post post, User loginUser, Rating rating)
	{
		this.post = post;
		this.loginUser = loginUser;
		this.rating = rating;
	}

	public User getLoginUser()
	{
		return loginUser;
	}

	public void setLoginUser(User loginUser)
	{
		this.loginUser = loginUser;
	}

	public Post getPost()
	{
		return post;
	}
	public void setPost(Post post)
	{
		this.post = post;
	}
	public Rating getRating()
	{
		if(post == null){
			return new Rating();
		}
		Rating userRating = post.getUserRating(loginUser.getId());
		if(userRating != null){
			rating = userRating;
		} else {
			rating = new Rating(post.getId(), loginUser.getId(), 0);
		}
		return rating;
	}
	public void setRating(Rating rating)
	{
		this.rating = rating;
	}
	
	public boolean isAlreadyRated()
	{
		return getRating().getRate() > 0;
	}
	
	
}

package com.packtpub.techbuzz.entities;

import java.io.Serializable;

/**
 *
 * @author siva
 */
public class Rating implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private int postId;
    private int userId;
    private int rate;

    public Rating() {
    }
    
	public Rating(int postId, int userId, int rate)
	{
		this.postId = postId;
		this.userId = userId;
		this.rate = rate;
	}

	@Override
	public String toString()
	{
		return "Rating [postId=" + postId + ", userId=" + userId + ", rate="
				+ rate + "]";
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

}

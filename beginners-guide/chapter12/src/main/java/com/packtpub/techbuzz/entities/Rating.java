package com.packtpub.techbuzz.entities;

import java.io.Serializable;

/**
 *
 * @author siva
 */
public class Rating implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    protected RatingId ratingId;
    private int rate;
    private User user;
    private Post post;

    public Rating() {
    }

    public Rating(RatingId ratingId) {
        this.ratingId = ratingId;
    }

    public Rating(RatingId ratingId, int rating) {
        this.ratingId = ratingId;
        this.rate = rating;
    }

    public Rating(int postId, int userId) {
        this.ratingId = new RatingId(postId, userId);
    }

    public RatingId getRatingId()
	{
		return ratingId;
	}

	public void setRatingId(RatingId ratingId)
	{
		this.ratingId = ratingId;
	}

	public int getRate()
	{
		return rate;
	}

	public void setRate(int rate)
	{
		this.rate = rate;
	}

	public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ratingId != null ? ratingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rating)) {
            return false;
        }
        Rating other = (Rating) object;
        if ((this.ratingId == null && other.ratingId != null) || (this.ratingId != null && !this.ratingId.equals(other.ratingId))) {
            return false;
        }
        return true;
    }
    
}

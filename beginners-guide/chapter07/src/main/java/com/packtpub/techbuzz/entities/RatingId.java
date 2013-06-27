
package com.packtpub.techbuzz.entities;

import java.io.Serializable;

/**
 *
 * @author siva
 */
public class RatingId implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
    private int postId;
    private int userId;

    public RatingId() {
    }

    public RatingId(int postId, int userId) {
        this.postId = postId;
        this.userId = userId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) postId;
        hash += (int) userId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RatingId)) {
            return false;
        }
        RatingId other = (RatingId) object;
        if (this.postId != other.postId) {
            return false;
        }
        if (this.userId != other.userId) {
            return false;
        }
        return true;
    }

    
}

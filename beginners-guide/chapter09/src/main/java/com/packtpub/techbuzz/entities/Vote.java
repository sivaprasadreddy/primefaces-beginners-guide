package com.packtpub.techbuzz.entities;

import java.io.Serializable;

/**
 *
 * @author siva
 */
public class Vote implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    protected VoteId voteId;
    private char voteType;
    private User user;
    private Post post;

    public Vote() {
    }

    public Vote(VoteId voteId) {
        this.voteId = voteId;
    }

    public Vote(VoteId voteId, char voteType) {
        this.voteId = voteId;
        this.voteType = voteType;
    }

    public Vote(int linkId, int userId) {
        this.voteId = new VoteId(linkId, userId);
    }

    public VoteId getVoteId() {
        return voteId;
    }

    public void setVotePK(VoteId voteId) {
        this.voteId = voteId;
    }

    public char getVoteType() {
        return voteType;
    }

    public void setVoteType(char voteType) {
        this.voteType = voteType;
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
        hash += (voteId != null ? voteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vote)) {
            return false;
        }
        Vote other = (Vote) object;
        if ((this.voteId == null && other.voteId != null) || (this.voteId != null && !this.voteId.equals(other.voteId))) {
            return false;
        }
        return true;
    }
    
}

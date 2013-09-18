package com.packtpub.techbuzz.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author siva
 */
public class Tag implements Serializable 
{
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String label;
    private String value;
    private String description;
    
    private List<Post> posts;

    public Tag() {
    }

    public Tag(Integer id) {
        this.id = id;
    }

    public Tag(Integer id, String label, String value) {
		this.id = id;
		this.label = label;
		this.value = value;
	}
    
	public Tag(Integer id, String label, String value, String description)
	{
		this.id = id;
		this.label = label;
		this.value = value;
		this.description = description;
	}

	@Override
	public String toString()
	{
		return "Tag [id=" + id + ", label=" + label + ", value=" + value
				+ ", posts=" + posts + "]";
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public List<Post> getPosts()
	{
		if(posts == null){
			posts = new ArrayList<Post>();
		}
		return posts;
	}

	public void setPosts(List<Post> posts)
	{
		this.posts = posts;
	}
	

}

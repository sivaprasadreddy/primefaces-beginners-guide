package com.packtpub.techbuzz.web.view;


/**
 * @author K. Siva Prasad Reddy
 * Date : 21-Sep-2013
 */
public class TagPostCountBean
{
	private String tag;
	private int postCount;
	
	public TagPostCountBean()
	{
	}

	public TagPostCountBean(String tag, int postCount)
	{
		this.tag = tag;
		this.postCount = postCount;
	}

	public String getTag()
	{
		return tag;
	}

	public void setTag(String tag)
	{
		this.tag = tag;
	}

	public int getPostCount()
	{
		return postCount;
	}

	public void setPostCount(int postCount)
	{
		this.postCount = postCount;
	}
	
}

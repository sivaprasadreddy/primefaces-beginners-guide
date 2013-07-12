package com.packtpub.techbuzz.web.view;

/**
 * @author K. Siva Prasad Reddy
 * Date : 06-Jul-2013
 */
public class TagStatistics
{
	private String tag;
	private int postsCountLastYear;
	private int postsCountThisYear;
	
	public TagStatistics()
	{
	}
	
	public TagStatistics(String tag, int postsCountLastYear, int postsCountThisYear)
	{
		this.tag = tag;
		this.postsCountLastYear = postsCountLastYear;
		this.postsCountThisYear = postsCountThisYear;
	}

	public String getTag()
	{
		return tag;
	}
	public void setTag(String tag)
	{
		this.tag = tag;
	}

	public int getPostsCountLastYear()
	{
		return postsCountLastYear;
	}

	public void setPostsCountLastYear(int postsCountLastYear)
	{
		this.postsCountLastYear = postsCountLastYear;
	}

	public int getPostsCountThisYear()
	{
		return postsCountThisYear;
	}

	public void setPostsCountThisYear(int postsCountThisYear)
	{
		this.postsCountThisYear = postsCountThisYear;
	}
	
}

package com.packtpub.techbuzz.web.view;

/**
 * @author K. Siva Prasad Reddy
 * Date : 11-Jul-2013
 */
public class PortfolioWidget
{
	private String title;
	private String image;
	private String description;
	
	public PortfolioWidget()
	{
	}

	public PortfolioWidget(String title, String image, String description)
	{
		this.title = title;
		this.image = image;
		this.description = description;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getImage()
	{
		return image;
	}

	public void setImage(String image)
	{
		this.image = image;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
	
}

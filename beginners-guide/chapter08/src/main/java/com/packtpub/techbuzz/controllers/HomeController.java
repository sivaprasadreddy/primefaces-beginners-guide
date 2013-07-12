package com.packtpub.techbuzz.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.packtpub.techbuzz.web.view.PortfolioWidget;


/**
 * @author K. Siva Prasad Reddy
 * Date : 11-Jul-2013
 */
@ManagedBean
@RequestScoped
public class HomeController
{
	private List<PortfolioWidget> portfolioWidgets;
	public HomeController()
	{
		portfolioWidgets = new ArrayList<PortfolioWidget>();
		portfolioWidgets.add(new PortfolioWidget("Who we are?", "", "We are blah blah blah"));
		portfolioWidgets.add(new PortfolioWidget("Products/Services", "", "Consulting, Software Development"));
		//portfolioWidgets.add(new PortfolioWidget("Support", "", "24X7 Tech Support"));
		
		portfolioWidgets.add(new PortfolioWidget("Downloads", "", "TechBuzz.zip"));
		portfolioWidgets.add(new PortfolioWidget("Contact US", "", "TechBuzz, Hyderabad"));
		portfolioWidgets.add(new PortfolioWidget("Partners", "", "Partner1, Partner2"));
		
		portfolioWidgets.add(new PortfolioWidget("Downloads", "", "TechBuzz.zip"));
		portfolioWidgets.add(new PortfolioWidget("Contact US", "", "TechBuzz, Hyderabad"));
		//portfolioWidgets.add(new PortfolioWidget("Partners", "", "Partner1, Partner2"));
		
		
	}
	
	public List<PortfolioWidget> getPortfolioWidgets()
	{
		return portfolioWidgets;
	}
}

package com.packtpub.techbuzz.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.packtpub.techbuzz.web.view.PostNode;

/**
 * @author K. Siva Prasad Reddy
 * Date : 12-Jul-2013
 */
@ManagedBean
@RequestScoped
public class TreeTableController
{
	
	private TreeNode root;

	@SuppressWarnings("unused")
	public TreeTableController() {
		
		root = new DefaultTreeNode("Root", null);
		
		TreeNode node2013 = new DefaultTreeNode(new PostNode("2013",""), root);
		TreeNode node2012 = new DefaultTreeNode(new PostNode("2012",""), root);
		TreeNode node2011 = new DefaultTreeNode(new PostNode("2011",""), root);
		
		TreeNode jan2013 = new DefaultTreeNode(new PostNode("Jan",""), node2013);
		TreeNode feb2013 = new DefaultTreeNode(new PostNode("Feb",""), node2013);
		
		TreeNode aug2012 = new DefaultTreeNode(new PostNode("Aug",""), node2012);
		TreeNode sep2012 = new DefaultTreeNode(new PostNode("Sep",""), node2012);
		
		TreeNode nov2011 = new DefaultTreeNode(new PostNode("Nov",""), node2011);
		
		
		TreeNode jan2013Post1 = new DefaultTreeNode("pic",new PostNode("PrimeFaces Elite 3.5.5 Released", "John"), jan2013);
		TreeNode jan2013Post2 = new DefaultTreeNode("pic",new PostNode("PrimeFaces Extensions 0.7 Released", "Mike"), jan2013);
		TreeNode feb2013Post1 = new DefaultTreeNode("video",new PostNode("Spring Framework 4.0 M1: WebSocket Support", "James"), feb2013);
		
		TreeNode aug2012Post1 = new DefaultTreeNode("document",new PostNode("EclipseLink 2.5 Release Available for Download", "Roger"), aug2012);
		TreeNode sep2012Post1 = new DefaultTreeNode("document",new PostNode("Building REST-ful services with Spring", "Jenny"), sep2012);
		
		TreeNode nov2011Post1 = new DefaultTreeNode("video", new PostNode("PrimeUI 0.9 Released", "Siva"), nov2011);
	}
	
	public TreeNode getRootx()
	{
		return root;
	}
	
}

package com.packtpub.techbuzz.controllers;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.event.TreeDragDropEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import com.packtpub.techbuzz.utils.JSFUtils;

/**
 * @author K. Siva Prasad Reddy
 * Date : 12-Jul-2013
 */
@ManagedBean
@RequestScoped
public class TreeController
{
	
	private TreeNode root;
	private TreeNode root1;
	private TreeNode rootx;
	
	private TreeNode selectedNode;
	private TreeNode selectedNode1;
	private TreeNode[] selectedNodes;

	@SuppressWarnings("unused")
	public TreeController() {
		root = new DefaultTreeNode("Root", null);
		
		TreeNode node2013 = new DefaultTreeNode("2013", root);
		TreeNode node2012 = new DefaultTreeNode("2012", root);
		TreeNode node2011 = new DefaultTreeNode("2011", root);
		
		TreeNode jan2013 = new DefaultTreeNode("Jan", node2013);
		TreeNode feb2013 = new DefaultTreeNode("Feb", node2013);
		
		TreeNode aug2012 = new DefaultTreeNode("Aug", node2012);
		TreeNode sep2012 = new DefaultTreeNode("Sep", node2012);
		
		TreeNode nov2011 = new DefaultTreeNode("Nov", node2011);
		
		
		TreeNode jan2013Post1 = new DefaultTreeNode("PrimeFaces Elite 3.5.5 Released", jan2013);
		TreeNode jan2013Post2 = new DefaultTreeNode("PrimeFaces Extensions 0.7 Released", jan2013);
		TreeNode feb2013Post1 = new DefaultTreeNode("Spring Framework 4.0 M1: WebSocket Support", feb2013);
		
		TreeNode aug2012Post1 = new DefaultTreeNode("EclipseLink 2.5 Release Available for Download", aug2012);
		TreeNode sep2012Post1 = new DefaultTreeNode("Building REST-ful services with Spring", sep2012);
		
		TreeNode nov2011Post1 = new DefaultTreeNode("PrimeUI 0.9 Released", nov2011);
		
		root1 = new DefaultTreeNode("Root1", null);
		
		TreeNode root1Node2013 = new DefaultTreeNode("2013", root1);
		TreeNode root1jan2013Post1 = new DefaultTreeNode("PrimeFaces Elite 4 Released", root1Node2013);
		TreeNode root1Node2012 = new DefaultTreeNode("2012", root1);
		TreeNode root1nov2011Post1 = new DefaultTreeNode("PrimeUI 1.0 Released", root1Node2012);
		
		//Tree with Icons
		rootx = new DefaultTreeNode("Root", null);
		
		TreeNode node2013x = new DefaultTreeNode("2013", rootx);
		TreeNode node2012x = new DefaultTreeNode("2012", rootx);
		TreeNode node2011x = new DefaultTreeNode("2011", rootx);
		
		TreeNode jan2013x = new DefaultTreeNode("Jan", node2013x);
		TreeNode feb2013x = new DefaultTreeNode("Feb", node2013x);
		
		TreeNode aug2012x = new DefaultTreeNode("Aug", node2012x);
		TreeNode sep2012x = new DefaultTreeNode("Sep", node2012x);
		
		TreeNode nov2011x = new DefaultTreeNode("Nov", node2011x);
		
		
		TreeNode jan2013Post1x = new DefaultTreeNode("pic","PrimeFaces Elite 3.5.5 Released", jan2013x);
		TreeNode jan2013Post2x = new DefaultTreeNode("pic","PrimeFaces Extensions 0.7 Released", jan2013x);
		TreeNode feb2013Post1x = new DefaultTreeNode("video","Spring Framework 4.0 M1: WebSocket Support", feb2013x);
		
		TreeNode aug2012Post1x = new DefaultTreeNode("document","EclipseLink 2.5 Release Available for Download", aug2012x);
		TreeNode sep2012Post1x = new DefaultTreeNode("document","Building REST-ful services with Spring", sep2012x);
		
		TreeNode nov2011Post1x = new DefaultTreeNode("video", "PrimeUI 0.9 Released", nov2011x);
	}

	public TreeNode getRoot() {
		return root;
	}
	public TreeNode getRoot1()
	{
		return root1;
	}
	public TreeNode getRootx()
	{
		return rootx;
	}
	public TreeNode[] getSelectedNodes() {
		return selectedNodes;
	}

	public void setSelectedNodes(TreeNode[] selectedNodes) {
		this.selectedNodes = selectedNodes;
	}
	
	public TreeNode getSelectedNode() {
		return selectedNode;
	}

	public void setSelectedNode(TreeNode selectedNode) {
		this.selectedNode = selectedNode;
	}
	
	public TreeNode getSelectedNode1()
	{
		return selectedNode1;
	}

	public void setSelectedNode1(TreeNode selectedNode1)
	{
		this.selectedNode1 = selectedNode1;
	}

	public void onNodeExpand(NodeExpandEvent event) {
		FacesMessage message = new FacesMessage("Expanded :"+ event.getTreeNode().toString());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void onNodeCollapse(NodeCollapseEvent event) {
		FacesMessage message = new FacesMessage("Collapsed :"+ event.getTreeNode().toString());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void onNodeSelect(NodeSelectEvent event) {
		FacesMessage message = new FacesMessage("Selected :"+ event.getTreeNode().toString());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

    public void onNodeUnselect(NodeUnselectEvent event) {
		FacesMessage message = new FacesMessage("Unselected :"+ event.getTreeNode().toString());
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void displaySelectedMultiple() {
        if(selectedNodes != null && selectedNodes.length > 0) {
            StringBuilder builder = new StringBuilder();

            for(TreeNode node : selectedNodes) {
                builder.append(node.getData().toString());
                builder.append("<br />");
            }
            FacesMessage message = new FacesMessage("Selected: "+ builder.toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
	}
	
	public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage("Selected :"+ selectedNode.getData().toString());
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
	}
	
	public void handleDragDrop(TreeDragDropEvent event) 
	{  
		TreeNode dragNode = event.getDragNode();  
		TreeNode dropNode = event.getDropNode();  
		int dropIndex = event.getDropIndex();  
		String msg = "Dragged " + dragNode.getData()+ " and Dropped on " + dropNode.getData() + " at " + dropIndex;
		JSFUtils.addInfoMsg(msg);
	}


}

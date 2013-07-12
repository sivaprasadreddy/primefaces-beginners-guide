package com.packtpub.techbuzz.controllers;

import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.DragDropEvent;
import org.primefaces.event.NodeCollapseEvent;
import org.primefaces.event.NodeExpandEvent;
import org.primefaces.event.NodeSelectEvent;
import org.primefaces.event.NodeUnselectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

/**
 * @author K. Siva Prasad Reddy
 * Date : 12-Jul-2013
 */
@ManagedBean
@RequestScoped
public class TreeController
{
	
	private TreeNode root;
	
	private TreeNode selectedNode;

	private TreeNode[] selectedNodes;

	public TreeController() {
		root = new DefaultTreeNode("Root", null);
		TreeNode node0 = new DefaultTreeNode("Node 0", root);
		TreeNode node1 = new DefaultTreeNode("Node 1", root);
		TreeNode node2 = new DefaultTreeNode("Node 2", root);
		
		TreeNode node00 = new DefaultTreeNode("Node 0.0", node0);
		TreeNode node01 = new DefaultTreeNode("Node 0.1", node0);
		
		TreeNode node10 = new DefaultTreeNode("Node 1.0", node1);
		TreeNode node11 = new DefaultTreeNode("Node 1.1", node1);
		
		TreeNode node000 = new DefaultTreeNode("Node 0.0.0", node00);
		TreeNode node001 = new DefaultTreeNode("Node 0.0.1", node00);
		TreeNode node010 = new DefaultTreeNode("Node 0.1.0", node01);
		
		TreeNode node100 = new DefaultTreeNode("Node 1.0.0", node10);
	}

	public TreeNode getRoot() {
		return root;
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
	
	public void onNodeExpand(NodeExpandEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Expanded", event.getTreeNode().toString());

		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void onNodeCollapse(NodeCollapseEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Collapsed", event.getTreeNode().toString());

		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void onNodeSelect(NodeSelectEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", event.getTreeNode().toString());
		
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

    public void onNodeUnselect(NodeUnselectEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Unselected", event.getTreeNode().toString());

		FacesContext.getCurrentInstance().addMessage(null, message);
	}

    public void onDragDrop(DragDropEvent event) {
        TreeNode node = (TreeNode) event.getData();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "DragDrop", node + " moved to " + node.getParent());

		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void displaySelectedMultiple() {
        if(selectedNodes != null && selectedNodes.length > 0) {
            StringBuilder builder = new StringBuilder();

            for(TreeNode node : selectedNodes) {
                builder.append(node.getData().toString());
                builder.append("<br />");
            }

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", builder.toString());

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
	}
	
	public void displaySelectedSingle() {
        if(selectedNode != null) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Selected", selectedNode.getData().toString());

            FacesContext.getCurrentInstance().addMessage(null, message);
        }
	}
    
    public void deleteNode() {
        selectedNode.getChildren().clear();
        selectedNode.getParent().getChildren().remove(selectedNode);
        selectedNode.setParent(null);
        
        selectedNode = null;
    }
}
